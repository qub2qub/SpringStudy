package by.den.spring.puzzlers.ironNbolt;

import javax.annotation.PostConstruct;

/**
 * Created by Denis on 11-02-2017
 */
public interface Iron {
    @PostConstruct
    void warmUp();
}
