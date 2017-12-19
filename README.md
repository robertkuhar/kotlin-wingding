# kotlin-wingding
WingDings covers the Kotlin Programming Language (https://kotlinlang.org/docs/reference) Autumn 2017

# Tentative Schedule

| Date   | Topic(s)                                             | Moderator |
|--------|------------------------------------------------------|-----------|
| Sep 27 | "Overview", "Getting Started" | Bob K |
| Oct 11 | "Basics",<br> "Classes and Objects" sections "Classes and Inheritence" through "Extensions" | Beau H |
| Oct 25 | "Classes and Objects" sections "Data Classes" through "Delegated Properties" | Terry |
| Nov 8  | "Functions and Lambdas" | Stan D |
| Nov 22 | Thanksgiving break | Turkey |
| Dec 13 | "Other",<br>"Destructuring Declarations" through "Null Safety" | Bob K |
| Dec 27 | Christmas break | Santa C |
| Jan 10 | "Other",<br>"Exceptions" through "Multiplatform Projects"<br>"Coroutines" from "Functions and Lambdas"| Bob K |
| Jan 24 | "Java Interop" and "Core Libraries" | Doug P |

# TODOs

* 2017-11-08:  Convert notes/* to MarkDown.

* 2017-10-08:  Creating WebApps with HttpServlet https://kotlinlang.org/docs/tutorials/httpservlets.html

  This should be possible without full IntelliJ Ultimate.  Gradle as some concept of "run WAR".

* 2017-10-08:  Creating a RESTful Web Service with Spring Boot https://kotlinlang.org/docs/tutorials/spring-boot-restful.html

  do this in a separate Repo as it will have a big effect on build.gradle

* 2017-10-08:  Can we version up Gradle to be more recent?  4.2.1 is current on 2017-10-08.
* 2017-10-08:  Can we run tests on commits in github?
* ~~2017-09-24:  Figure out how to get Kotlin tests supported~~

  Integrating JUnit 4 tests involves 3 things:

  1. build.gradle dependencies get `testCompile group: 'junit', name: 'junit', version: '4.12'`
  2. Annotate tests in `src/test/kotlin` directory like `@org.junit.Test`
  3. Configure the `test` task in build.gradle with `testLogging` property set for `showStandardStreams = true` to
  improve the output to standard out when test(s) fail

* ~~2017-09-24:  Figure out how to build and run Kotlin through Gradle~~

  The IntelliJ wizard seems to have done this.  Its just `apply plugin: 'kotlin'` in build.gradle and from there it is
  straight-up `gradle build`.  Why are we in Gradle 3.5, though?  Do I need to version up tcc-rkuhar.local?
