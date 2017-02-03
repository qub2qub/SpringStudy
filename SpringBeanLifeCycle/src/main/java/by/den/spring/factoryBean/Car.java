package by.den.spring.factoryBean;

import org.springframework.util.Assert;

import javax.annotation.PostConstruct;

/**
 * Created by Denis on 22 Январь 2017
 */
public class Car {
    String make;
    Integer year;

    public Car(String make, Integer year) {
        this.make = make;
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * Метов НЕ вызовется, т.к. не загружена конфигурация с аннотациями.
     * Надо явно указать init-method в bean.xml конфиге.
     * Но т.к. здесь ис-ся FactoryBean - то этот метод надо указывать в нём.
     */
    @PostConstruct
    public void sanityCheck() throws Throwable {
        System.out.println("\n********* sanityCheck_1 Car *********");
        // these methods throw an exception that
        // will arrest construction if the assertions aren't met
        Assert.notNull(this.make, "the 'make' must not be null")	;
        Assert.isTrue(this.year > 0, "the 'year' must be a valid value");
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", year=" + year +
                '}';
    }
}
