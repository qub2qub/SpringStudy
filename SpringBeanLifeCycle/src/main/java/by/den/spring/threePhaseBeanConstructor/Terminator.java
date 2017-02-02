package by.den.spring.threePhaseBeanConstructor;

import javax.annotation.PostConstruct;

/**
 * Created by Denis on 01-02-2017
 */
@Profiler
public class Terminator implements Quoter, AfterProxyInit {

    @InjectRandomInteger(min = 2, max = 7)
    private int repeat;

    private String message;

    public Terminator() {
        System.out.println("__________ >> Phase 1 >> Constructor");
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    @AfterProxy
    public void afterProxyCall() {
        System.out.println("__________ >> Phase 3 >> ContextRefresh >> @AfterProxy >> afterProxyCall()");
    }

    @Override
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }

    @PostConstruct
    private void initTerm() {
        System.out.println("__________ >> Phase 2 >> @PostConstruct >> initTerm()");
    }

    @PostConstruct
    private void postConstruct2nd() {
        System.out.println("__________ >>> Phase 2 >> @PostConstruct >> postConstruct2nd() >> sayQuote() >>");
        System.out.println("при этом здесь профилирования не будет, т.к. на фазе @PostConstruct" +
                "\nещё не была обработана @Profiler, и не был сделан proxy.");
        sayQuote();
        System.out.println("_________ <<< end << Phase 2 << @PostConstruct >> postConstruct2nd()");
    }

    /**
     *  @ AfterProxy НЕ СРАБОТАЕТ на методе, который не определён в интерфейсе,
     *  т.к. раньше будет создан прокси объект для интерфейса,
     *  и следовательно, методы у прокси будут только те, что есть в интерфейсе.
     */
//    @AfterProxy
    public void phase3rdContextRefresh() {
        System.out.println("__________ >> Phase 3 >> ContextRefresh >> @AfterProxy >> phase3rdContextRefresh()");
    }
}
