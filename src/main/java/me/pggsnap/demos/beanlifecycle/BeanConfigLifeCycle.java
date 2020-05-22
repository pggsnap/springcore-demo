package me.pggsnap.demos.beanlifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @author pggsnap
 * @date 2020/4/24
 */
@Configuration
public class BeanConfigLifeCycle {
    @Bean
    public BeanAware beanAware() {
        return new BeanAware();
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Bean1 bean1() {
        return new Bean1();
    }

    @Bean
    public Bean2 bean2() {
        return new Bean2();
    }

    @Lazy
    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public Bean3 bean3() {
        return new Bean3();
    }
}
