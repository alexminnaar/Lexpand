import edu.stanford.nlp.ling.HasWord
import github.alexminnaar.Tokenizer
import org.scalatest.{Matchers, WordSpec}


class ParsingSpec extends WordSpec with Matchers {

  "Lexical Parser" should {

    "Parse multiple sentences correctly" in {


      val testSentences = "I went to the store. Then I went to the movies."

      val tokens = Tokenizer.ssplitTokenize(testSentences)

      val gold=List(
        Vector("I", "went", "to", "the", "store", "."),
        Vector("Then", "I", "went", "to", "the", "movies", ".")
      )

      tokens.map(_.map(_.word())) should equal(gold)


    }


  }

}
