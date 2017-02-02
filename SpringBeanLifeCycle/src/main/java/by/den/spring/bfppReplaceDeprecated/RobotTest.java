package by.den.spring.bfppReplaceDeprecated;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Denis on 02-02-2017
 */
public class RobotTest {

    @Test
    public void createT1st() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "bfpp-change-beanDefinitions.xml");

        Robot t1st = context.getBean(T1st.class);
//        Robot t1st = context.getBean(Robot.class);
//        T1st t1st = context.getBean(T1st.class);
        t1st.sayBye();
    }

}
