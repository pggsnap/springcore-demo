package me.pggsnap.demos.beanlifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author pggsnap
 * @date 2020/4/24
 */
public class Bean2 implements InitializingBean, DisposableBean {
    public Bean2() {
        System.out.println("bean2 constructor...");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("bean2 init...");
    }

    @Override
    public void destroy() {
        System.out.println("bean2 destroy...");
    }
}
