package by.den.spring.beanPostProcessor;

import by.den.spring.threePhaseBeanConstructor.InjectRandomInteger;

public class HelloWorldBean {

   private String message;

   @InjRndIntANN(min = 100, max = 999)
   private Integer number;

   public void setMessage(String message){
      this.message  = message;
   }

   public void getMessage(){
      System.out.println("Your Message : " + message);
   }

   public Integer getNumber() {
      return number;
   }

   public void setNumber(Integer number) {
      this.number = number;
   }

   public void init(){
      System.out.println("INIT МЕТОД");
   }

   public void destroy(){
      System.out.println("DESTROY МЕТОД");
   }

   @Override
   public String toString() {
      return "HelloWorldBean{" +
              "message='" + message + '\'' +
              ", number=" + number +
              '}';
   }
}