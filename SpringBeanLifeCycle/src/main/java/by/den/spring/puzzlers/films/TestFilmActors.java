package by.den.spring.puzzlers.films;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Denis on 11-02-2017
 */
public class TestFilmActors {

    @Test
    public void findAll() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        FilmConfig.class);
        FilmService service = context.getBean(FilmService.class);

        System.out.print("\ncomedyAction = ");
        service.comedyAction.forEach(Actor::play);

        System.out.print("\n\nanyGenre = ");
        service.anyGenre.forEach(   (act)->act.play()   );

        System.out.print("\n\nnoQualif = ");
        service.noQualif.forEach(Actor::play);

    }

}
