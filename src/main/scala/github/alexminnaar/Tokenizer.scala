package github.alexminnaar

import java.io.StringReader

import edu.stanford.nlp.ling.HasWord
import edu.stanford.nlp.process.DocumentPreprocessor
import scala.collection.JavaConversions._


object Tokenizer {

  //tokenize and sentence split raw text
  def ssplitTokenize(text: String): Seq[Seq[HasWord]] = {
    val reader = new StringReader(text)
    val preprocessor = new DocumentPreprocessor(reader)
    preprocessor.map(_.toIndexedSeq).toSeq
  }


}
