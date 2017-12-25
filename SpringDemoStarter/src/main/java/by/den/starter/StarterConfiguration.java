package by.den.starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@EnableConfigurationProperties(NotificationProperties.class)
public class StarterConfiguration {
  @Bean
  @Profile("PROD")
  @ConditionalOnMissingBean(name = "productionStartedNotificationListener")
  @ConditionalOnProperty(name = "prod.enabled", havingValue = "true", matchIfMissing = true)
  public ProductionStartedNotificationListener listener() {
    return new ProductionStartedNotificationListener();
  }
}
