package by.den.spring.beanPostProcessor;

import by.den.spring.threePhaseBeanConstructor.InjectRandomInteger;
import by.den.spring.threePhaseBeanConstructor.Profiler;

@Profiler
public class HelloWorldBean {

   private String message;

   @InjRndIntANN(min = 100, max = 999)
   private Integer number;

   @InjectRandomInteger
   private Integer count;

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

   public Integer getCount() {
      return count;
   }

   public void setCount(Integer count) {
      this.count = count;
   }

   public void init(){
      System.out.println("Bean is going through init.");
   }

   public void destroy(){
      System.out.println("Bean will destroy now.");
   }

   @Override
   public String toString() {
      return "HelloWorldBean{" +
              "message='" + message + '\'' +
              ", number=" + number +
              ", count=" + count +
              '}';
   }
}