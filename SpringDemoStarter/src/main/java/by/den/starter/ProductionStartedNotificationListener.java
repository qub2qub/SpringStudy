package by.den.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class ProductionStartedNotificationListener implements ApplicationListener<ContextRefreshedEvent> {
  
  @Autowired
  private NotificationProperties notificationProperties;
  
  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    notificationProperties.getMails().forEach(System.out::println);
  }
}
