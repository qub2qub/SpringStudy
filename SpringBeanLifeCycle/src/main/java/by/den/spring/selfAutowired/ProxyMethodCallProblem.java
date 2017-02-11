package by.den.spring.selfAutowired;

import by.den.spring.threePhaseBeanConstructor.ProfilerBenchmark;
import org.springframework.stereotype.Component;

/**
 * Created by Denis on 03-02-2017
 */
@Component
@ProfilerBenchmark
public class ProxyMethodCallProblem implements ThreeMethods {

    @SelfAutowired
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
