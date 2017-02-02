package by.den.spring.beanFactory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

public class MyCarFactoryBean implements FactoryBean<Car> {
  private String make; 
  private int year ;

  public void setMake(String m){ this.make =m ; }

  public void setYear(int y){ this.year = y; }

  public Car getObject(){ 
    // wouldn't be a very useful FactoryBean 
    // if we could simply instantiate the object!
//    CarBuilder cb = CarBuilder.car();
//      if(year!=0) cb.setYear(this.year);
//    if(StringUtils.hasText(this.make)) cb.setMake( this.make );
//    return cb.factory();
    return new Car(make, year);
  }

  public void sanityCheck() throws Throwable {
    System.out.println("\n********* sanityCheck_2 MyCarFactoryBean *********");
    // these methods throw an exception that
    // will arrest construction if the assertions aren't met
    Assert.notNull(this.make, "the 'make' must not be null")	;
    Assert.isTrue(this.year > 0, "the 'year' must be a valid value");
  }

  public Class<Car> getObjectType() { return Car.class ; } 

  public boolean isSingleton() { return false; }
}