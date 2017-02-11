package by.den.spring.puzzlers.films;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Denis on 11-02-2017
 */
@Service
public class FilmService {

    @Autowired @Comedy @Action
    public List<Actor> comedyAction;

    @Autowired @AnyGenre
    public List<Actor> anyGenre;

    @Autowired
    public List<Actor> noQualif;

}
