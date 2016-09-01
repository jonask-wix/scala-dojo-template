
import org.scalacheck.Gen
import org.scalatest.prop.PropertyChecks
import org.scalatest.{Matchers, PropSpec}


class RomanNumeralsSpec extends PropSpec with PropertyChecks with Matchers {
  implicit override val generatorDrivenConfig =
    PropertyCheckConfig(minSuccessful = 100)

  val validInputs = Gen.choose(1, 3999)

  property("should have only IXCVLMD letters") {
    forAll(validInputs) { i =>
      arabicToRoman(i) should fullyMatch regex "^[IXCVLMD]*$"
    }
  }

  property("shouldn't have more than 4 I's in a row") {
    forAll(validInputs) { i =>
      arabicToRoman(i) should not include  regex("IIIII")
    }
  }

  property("shouldn't have more than 1 V's in a row") {
    forAll(validInputs) { i =>
      arabicToRoman(i) should not include  regex("VV")
    }
  }

  property("shouldn't have more than 4 X's in a row") {
    forAll(validInputs) { i =>
      arabicToRoman(i) should not include  regex("XXXXX")
    }
  }

  property("shouldn't have more than 1 L's in a row") {
    forAll(validInputs) { i =>
      arabicToRoman(i) should not include  regex("LL")
    }
  }

  property("shouldn't have more than 4 C's in a row") {
    forAll(validInputs) { i =>
      arabicToRoman(i) should not include  regex("CCCCC")
    }
  }

  property("shouldn't have more than 1 D's in a row") {
    forAll(validInputs) { i =>
      arabicToRoman(i) should not include regex("DD")
    }
  }

  property("if number ends 4 it should end with IV") {
    forAll(validInputs) { i =>
      if((i % 10 ) == 4 ){
        arabicToRoman(i) should  endWith regex "IV"
      }
    }
  }

  property("if number ends 9 it should end with IX") {
    forAll(validInputs) { i =>
      if((i % 10 ) == 9 ){
        arabicToRoman(i) should  endWith regex "IX"
      }
    }
  }

  property("if arabic has 4 tens then roman has one XL") {
    forAll(validInputs) { i =>
      if((i % 100 /10) == 4 ){
        arabicToRoman(i) should  include regex "XL"
      }
    }
  }

  property("if arabic has 9 tens then roman has one XC") {
    forAll(validInputs) { i =>
      if((i % 100 /10) == 9 ){
        arabicToRoman(i) should  include regex "XC"
      }
    }
  }

  property("if arabic has 4 hundreds then roman has one CD") {
    forAll(validInputs) { i =>
      if((i % 1000 /100) == 4 ){
        arabicToRoman(i) should  include regex "CD"
      }
    }
  }

  property("if arabic has 9 hundreds then roman has one CM") {
    forAll(validInputs) { i =>
      if((i % 1000 /100) == 9 ){
        arabicToRoman(i) should  include regex "CM"
        println(arabicToRoman(3999))
      }
    }
  }

  def arabicToRoman(arabic: Int): String = {
    ("I" * arabic)
      .replaceAll("IIIII", "V")
      .replaceAll("VV", "X")
      .replaceAll("XXXXX", "L")
      .replaceAll("LL", "C")
      .replaceAll("CCCCC", "D")
      .replaceAll("DD", "M")
      .replaceAll("IIII", "IV")
      .replaceAll("VIV", "IX")
      .replaceAll("XXXX", "XL")
      .replaceAll("LXL", "XC")
      .replaceAll("CCCC", "CD")
      .replaceAll("DCD", "CM")
  }
}

