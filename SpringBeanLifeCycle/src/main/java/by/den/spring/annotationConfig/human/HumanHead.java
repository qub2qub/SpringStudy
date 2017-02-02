package by.den.spring.annotationConfig.human;

/**
 * Created by Denis on 02-02-2017
 */
public class HumanHead implements Head {

    Eyes eyes;

    public Eyes getEyes() {
        return eyes;
    }

    public void setEyes(Eyes eyes) {
        this.eyes = eyes;
    }

    @Override
    public void look() {
        if (eyes != null) {
            System.out.println("I see !");
        } else {
            System.out.println("I have no eyes !!");
        }
    }

    @Override
    public void think() {
        System.out.println("Head is thinking..");
    }
}
