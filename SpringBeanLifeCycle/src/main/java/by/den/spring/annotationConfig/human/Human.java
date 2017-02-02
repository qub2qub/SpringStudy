package by.den.spring.annotationConfig.human;

/**
 * Created by Denis on 02-02-2017
 */
public class Human implements Humanoid {
    Head head;
    Legs legs;

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Legs getLegs() {
        return legs;
    }

    public void setLegs(Legs legs) {
        this.legs = legs;
    }

    public void look() {
        if (head != null) {
            head.look();
        } else {
            System.out.println("I have NO head to look !");
        }
    }

    @Override
    public void stand() {
        if (legs != null) {
            System.out.println("I stand !");
        } else {
            System.out.println("I have NO legs!");
        }
    }

    void wakeUp() {
        System.out.println("Человеку ещё надо проснуться !!! ");
    }
}
