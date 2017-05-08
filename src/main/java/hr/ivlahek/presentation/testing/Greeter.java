package hr.ivlahek.presentation.testing;

import javax.inject.Inject;
import java.io.PrintStream;

/**
 * @author ivlahek
 */
public class Greeter {
  @Inject
  private PhraseBuilder phraseBuilder;

  public Greeter() {
  }

  public String createGreeting(String name) {
    return phraseBuilder.buildPhrase("hello", name);
  }

  public Greeter(PhraseBuilder phraseBuilder) {
    this.phraseBuilder = phraseBuilder;
  }

  public void greet(PrintStream to, String name) {
    to.println(createGreeting(name));
  }


}
