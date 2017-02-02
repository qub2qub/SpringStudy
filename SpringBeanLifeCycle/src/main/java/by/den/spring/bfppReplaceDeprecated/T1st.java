package by.den.spring.bfppReplaceDeprecated;

import by.den.spring.threePhaseBeanConstructor.Quoter;

/**
 * Created by Denis on 02-02-2017
 */
@DeprecatedClass(newImpl = T1000.class)
public class T1st implements Robot {
    @Override
    public void sayBye() {
        System.out.println("I'm the FIRST terminator ! Bye !");
    }
}
