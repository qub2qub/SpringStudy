package by.den.spring.annotationConfig;

import by.den.spring.annotationConfig.animals.Animal;
import by.den.spring.annotationConfig.animals.Cat;
import by.den.spring.annotationConfig.animals.Dog;
import by.den.spring.annotationConfig.human.Human;
import by.den.spring.annotationConfig.human.Humanoid;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Denis on 02-02-2017
 */
public class RunAnnCtx
{
  public static void main(String[] args)
  {
    AnnotationConfigApplicationContext context =
      new AnnotationConfigApplicationContext(
//        "by.den.spring.annotationConfig.beans");
//    Dog.class);
    //лучше регать класс с аннотацией @Configuration, т.к. в ней могу добавляться другие бины
    AnimalsJavaConfig.class);

    Animal animal = context.getBean(Cat.class);
    System.out.print(animal.myNameIs() + " ++ ");
    animal.voice();

    Humanoid hum1 = (Humanoid) context.getBean("deadHumanoid");
    hum1.stand();

    // No qualifying bean of type 'by.den.spring.annotationConfig.human.Humanoid' available:
    // expected single matching bean but found 2: JasonBorn,deadHumanoid
    //        Human human = context.getBean(Human.class);
    Human human = (Human) context.getBean("JasonBorn");
    human.stand();
    human.look();

    Animal snake = (Animal) context.getBean("snake");
    System.out.print(snake.myNameIs() + " ++ ");
    snake.voice();
  }
}
