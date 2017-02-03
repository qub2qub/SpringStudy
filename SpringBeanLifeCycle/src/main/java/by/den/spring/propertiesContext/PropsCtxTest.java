package by.den.spring.propertiesContext;

import by.den.spring.bfppReplaceDeprecated.T1st;
import org.junit.Test;

/**
 * Created by Denis on 03-02-2017
 */
public class PropsCtxTest {

    @Test
    public void loadCtx() {
        PropertyFileApplicationContext context =
                new PropertyFileApplicationContext(
                        "propsContext.properties");

        T1st bean = context.getBean(T1st.class);
        bean.sayBye();

    }

}
