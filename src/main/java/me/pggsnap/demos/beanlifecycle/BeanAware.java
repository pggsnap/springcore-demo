package me.pggsnap.demos.beanlifecycle;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
/**
 * @author pggsnap
 * @date 2020/4/24
 */
public class BeanAware implements ApplicationContextAware {
    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public BeanAware() {
        System.out.println("beanAware constructor...");
    }

    /**
     * 1. 初始化 BeanAware 时，先执行 step1；
     * 2. 执行 step2 的打印语句时，会先实例化别的带有 @Bean 注解的 bean，即使别的 bean 注明了 @Lazy
     */
    @PostConstruct
    public void init() {
        System.out.println("beanAware init...");    // step1
        context.getBeansWithAnnotation(Bean.class).entrySet().stream()
                .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue().getClass().getSimpleName()));   // step2
    }

    @PreDestroy
    public void destroy(){
        System.out.println("beanAware destroy...");
    }
}
