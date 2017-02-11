package by.den.spring.puzzlers.prod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Denis on 11-02-2017
 */
@Component
public class ProdService {

    @Autowired
    public List<String> allStrList;

    @Autowired @ProdQualifier
    public List<String> prodStrList;


}
