package by.den.spring.puzzlers.ironNbolt;

/**
 * Created by Denis on 11-02-2017
 */
public class БольшойПаяльник implements Паяльник {
    @Override
    public void греться() {
        System.out.println("БольшойПаяльник >> Долго греется ....");
    }
}
