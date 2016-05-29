package github.alexminnaar


import edu.stanford.nlp.ling.HasWord
import edu.stanford.nlp.parser.lexparser.LexicalizedParser
import edu.stanford.nlp.trees.PennTreebankLanguagePack
import github.alexminnaar.Types.DepPair
import scala.collection.JavaConversions._

object SentenceParser {

  val lexParser = LexicalizedParser.loadModel("edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz")

  //extract dependency pairs within sentence tokens
  def parse(sentenceTokens: Seq[HasWord]) = {
    val parseTree = lexParser.apply(sentenceTokens)
    val tlp = new PennTreebankLanguagePack()
    val gsf = tlp.grammaticalStructureFactory()
    val gs = gsf.newGrammaticalStructure(parseTree)
    val tdl = gs.typedDependenciesCCprocessed()

    tdl.map { x =>

      DepPair(
        w1 = x.gov().toString(),
        rel = x.reln().toString,
        w2 = x.dep().toString()
      )

    }
  }

}