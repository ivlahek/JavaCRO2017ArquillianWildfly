package hr.ivlahek.presentation.testing;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

/**
 * Created by ivlahek on 23.4.2017..
 */
@RunWith(Arquillian.class)
public class GreeterTest {

  @Inject
  Greeter greeter;

  @Deployment
  public static WebArchive createDeployment() {
    WebArchive jar = ShrinkWrap.create(WebArchive.class)
        .addClasses(Greeter.class, PhraseBuilder.class)
        .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    System.out.println(jar.toString(true));
    return jar;
  }

  @Test
  public void should_create_greeting() {
    Assert.assertEquals("Hello, Earthling!", greeter.createGreeting("Earthling"));
    greeter.greet(System.out, "Earthling");
  }
}
