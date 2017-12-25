package by.den.spring.beanPostProcessor;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunBPP {

   public static void main(String[] args) {

      AbstractApplicationContext context = new ClassPathXmlApplicationContext("bppBeans.xml");

      Object helloWorldBean = context.getBean("helloWorldBean");
      System.out.println(">>>>>>>>>>>>>>>> " + helloWorldBean);
      context.registerShutdownHook();
      context.close();
      System.out.println("\n_________ Spring Context Closed _________");
   }
}