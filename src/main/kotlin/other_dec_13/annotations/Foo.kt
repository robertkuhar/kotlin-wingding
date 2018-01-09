package other_dec_13.annotations

class MyDependency {}

@Fancy @Special("robert") class Foo @Fancy constructor(dependency: MyDependency) {

    @Fancy fun baz(@Fancy foo: Int): Int {
        return (@Fancy 1) }
}
