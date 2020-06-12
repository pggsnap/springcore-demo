package me.pggsnap.demos.beanlifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.MessageSource;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author pggsnap
 * @date 2020/4/27
 */
@Component
@Order(10)
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass() == Bean1.class) {
            System.out.println("bean1 before init");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass() == Bean2.class) {
            System.out.println("bean2 after init");
        }
        return bean;
    }

    @Autowired
    private MessageSource messageSource;
}
