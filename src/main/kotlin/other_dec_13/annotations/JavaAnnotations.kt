package other_dec_13.annotations

@Ann(intValue = 1, stringValue = "abc")
class C {

}

@AnnWithValue("abc")
class D {

}

@AnnWithArrayValue("Moe", "Larry", "Curly")
class E {

}

@AnnWithArrayMethod(names = ["abc", "foo", "bar"])
class F {

}

@AnnWithArrayMethod(names = arrayOf("def", "baz", "steelers"))
class G {

}
