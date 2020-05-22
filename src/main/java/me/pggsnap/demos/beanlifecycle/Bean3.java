package me.pggsnap.demos.beanlifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author pggsnap
 * @date 2020/4/24
 */
public class Bean3 implements InitializingBean, DisposableBean {
    public Bean3() {
        System.out.println("bean3 constructor...");
    }

    public void initMethod() {
        System.out.println("bean3 init by initMethod...");
    }

    public void destroyMethod() {
        System.out.println("bean3 destroy by destroyMethod...");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("bean3 init by InitializingBean...");
    }

    @Override
    public void destroy() {
        System.out.println("bean3 destroy by DisposableBean...");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("bean3 init by @PostConstruct...");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("bean3 destroy by @PreDestroy...");
    }

}
