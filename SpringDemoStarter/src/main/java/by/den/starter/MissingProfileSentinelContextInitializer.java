package by.den.starter;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class MissingProfileSentinelContextInitializer implements ApplicationContextInitializer{
  
  @Override
  public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
    if (configurableApplicationContext.getEnvironment().getActiveProfiles().length==0) {
      throw new IllegalStateException("Запрещено запускать без active profiles !!");
    }
  }
}
