import org.specs2.ScalaCheck
import org.specs2.mutable.Specification


class ExampleSpec extends Specification with ScalaCheck {
  "example test" should {
    "pass with any integer" ! prop { i: Int =>
      i == i
    }
  }
}
