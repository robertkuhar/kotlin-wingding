/**
 * This is an example of a Type-Safe Groovy-style Builder
 *
 * Builders are good for declaratively describing data in your code.
 * In this example we show how to describe an HTML page in Kotlin.
 *
 * See this page for details:
 * http://kotlinlang.org/docs/reference/type-safe-builders.html
 */
package other_dec_13.builders.htmlbuilder

fun main(args: Array<String>) {
    val result =
            html {
                this.log("begin html")

                // aka. this.head
                head {
                    title { +"XML encoding with Kotlin" }
                    /*
                     * BobK:  it not clear to me exactly HOW the @HtmlTagMarker stunt makes the "head in head" an error.
                     *
                     * Uncomment below and hover over the error.
                     */
                    // head{}
                    this@html.log("this@html.log is how you reference your parent's receiver")
                }
                body {
                    h1 { +"XML encoding with Kotlin" }
                    p { +"this format can be used as an alternative markup to XML" }

                    // an element with attributes and text content
                    a(href = "http://jetbrains.com/kotlin") { +"Kotlin" }

                    // mixed content
                    p {
                        +"This is some"
                        b { +"mixed" }
                        +"text. For more see the"
                        a(href = "http://jetbrains.com/kotlin") { +"Kotlin" }
                        +"project"
                    }
                    p { +"some text" }

                    if (args.size > 0) {
                        val prompt = if (args.size == 1) "argument" else "arguments"
                        // content generated from command-line arguments
                        p {
                            +"Command line $prompt"
                            ul {
                                for (arg in args) li { +arg }
                            }
                        }
                    }

                }
                this.log("end html")
            }
    System.err.println("result is of type ${result::class}")
    println(result)
}

interface Element {
    fun render(builder: StringBuilder, indent: String)
}

class TextElement(val text: String) : Element {
    override fun render(builder: StringBuilder, indent: String) {
        builder.append("$indent$text\n")
    }
}

@DslMarker
annotation class HtmlTagMarker

@HtmlTagMarker
abstract class Tag(val name: String) : Element {
    val children = arrayListOf<Element>()
    val attributes = hashMapOf<String, String>()

    protected fun <T : Element> initTag(tag: T, init: T.() -> Unit): T {
        tag.init()
        children.add(tag)
        return tag
    }

    override fun render(builder: StringBuilder, indent: String) {
        builder.append("$indent<$name${renderAttributes()}>\n")
        for (c in children) {
            c.render(builder, indent + "  ")
        }
        builder.append("$indent</$name>\n")
    }

    private fun renderAttributes(): String? {
        val builder = StringBuilder()
        for (a in attributes.keys) {
            builder.append(" $a=\"${attributes[a]}\"")
        }
        return builder.toString()
    }

    override fun toString(): String {
        val builder = StringBuilder()
        render(builder, "")
        return builder.toString()
    }
}

abstract class TagWithText(name: String) : Tag(name) {
    operator fun String.unaryPlus() {
        children.add(TextElement(this))
    }
}

class HTML() : TagWithText("html") {
    fun head(init: Head.() -> Unit) = initTag(Head(), init)

    fun body(init: Body.() -> Unit) = initTag(Body(), init)

    fun log(message: String) {
        System.err.println("log: $message")
    }
}

class Head() : TagWithText("head") {
    fun title(init: Title.() -> Unit) = initTag(Title(), init)
}

class Title() : TagWithText("title")

abstract class BodyTag(name: String) : TagWithText(name) {
    fun b(init: B.() -> Unit) = initTag(B(), init)
    fun p(init: P.() -> Unit) = initTag(P(), init)
    fun h1(init: H1.() -> Unit) = initTag(H1(), init)
    fun ul(init: UL.() -> Unit) = initTag(UL(), init)
    fun a(href: String, init: A.() -> Unit) {
        val a = initTag(A(), init)
        a.href = href
    }
}

class Body() : BodyTag("body")
class UL() : BodyTag("ul") {
    fun li(init: LI.() -> Unit) = initTag(LI(), init)
}

class B() : BodyTag("b")
class LI() : BodyTag("li")
class P() : BodyTag("p")
class H1() : BodyTag("h1")

class A() : BodyTag("a") {
    public var href: String
        get() = attributes["href"]!!
        set(value) {
            attributes["href"] = value
        }
}

fun html(init: HTML.() -> Unit): HTML {
    val html = HTML()
    html.init()
    return html
}
