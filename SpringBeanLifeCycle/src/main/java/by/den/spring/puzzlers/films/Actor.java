package by.den.spring.puzzlers.films;

/**
 * Created by Denis on 11-02-2017
 */
public interface Actor {
    default void play() {
        System.out.print(this.getClass().getSimpleName()+", ");
    }
}
