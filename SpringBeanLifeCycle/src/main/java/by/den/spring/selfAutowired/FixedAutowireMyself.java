package by.den.spring.selfAutowired;

import by.den.spring.threePhaseBeanConstructor.ProfilerBenchmark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Denis on 11-02-2017
 *
 * НО НИХУЯ НЕ РАБОТАЕТ !
 */
@Component @FixedAutowiredQualifier
@ProfilerBenchmark
public class FixedAutowireMyself implements ThreeMethods {

    @Autowired @FixedAutowiredQualifier
    ThreeMethods me; // fix the problem

    @Override
    public void aaa() {
        System.out.println("m_aaa");
    }

    @Override
    public void bbb() {
        System.out.println("m_bbb");
    }

    @Override
    public void cccProblem() {
        System.out.println("m_ccc");
        //aaa(); // this.aaa(); // -- и метод будет вызван напрямую, без прокси
        me.aaa();
    }

}