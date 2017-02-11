package by.den.spring.puzzlers.placeholder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by Denis on 11-02-2017
 */
public class PropService {

    @Value("${JAVA_HOME}")
    private void initPropService(String jh) {
        System.out.println("JAVA_HOME="+jh);
    }

    private void noArgInitPropService() {
        System.out.println("PropService --- no arg init --- ");
//        initPropService("2nd call");
    }

}
