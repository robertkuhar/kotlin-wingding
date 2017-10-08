# kotlin-wingding
WingDings covers the Kotlin Programming Language (https://kotlinlang.org/docs/reference) Autumn 2017

# Tentative Schedule

| Date   | Topic(s)                                             | Moderator |
|--------|------------------------------------------------------|-----------|
| Sep 27 | "Overview", "Getting Started" | Bob K |
| Oct 11 | "Basics",<br> "Classes and Objects" sections "Classes and Inheritence" through "Sealed Classes" | Beau H |
| Oct 25 | "Classes and Objects" sections "Generics" through "Delegated Properties" | Terry |
| Nov 8  | "Functions and Lambdas" | Stan D |
| Nov 22 | Thanksgiving break | Turkey |
| Dec 13 | "Other" | ? |
| Dec 27 | Christmas break | Santa C |
| Jan 10 | "Java Interop" and "Core Libraries" | ? |

# TODO

* ~~2017-09-24:  Figure out how to build and run Kotlin through Gradle~~

  2017-10-08:  The IntelliJ wizard seems to have done this.  Its just `apply plugin: 'kotlin'` in build.gradle and from
  there it is straight-up `gradle build` or `gradle test`

* ~~2017-09-24:  Figure out how to get Kotlin tests supported~~

  2017-10-08:  JUnit 4 tests involve just required 3 things

  1. `testCompile group: 'junit', name: 'junit', version: '4.12'` into the dependencies of build.gradle
  2. Tests in `src/test/kotlin` directory and annotated like `@org.junit.Test`
  3. build.gradle `test` task gets `testLogging` property set for `showStandardStreams = true`
