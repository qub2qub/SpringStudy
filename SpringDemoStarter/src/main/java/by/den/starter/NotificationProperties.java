package by.den.starter;

import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "prod")
public class NotificationProperties {
  
  private List<String> mails;
  private boolean enabled;
  
  public List<String> getMails() {
    return mails;
  }
  
  public void setMails(List<String> mails) {
    this.mails = mails;
  }
  
  public boolean isEnabled() {
    return enabled;
  }
  
  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }
}
