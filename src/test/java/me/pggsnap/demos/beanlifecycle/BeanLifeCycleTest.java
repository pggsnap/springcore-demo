package me.pggsnap.demos.beanlifecycle;

import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author pggsnap
 * @date 2020/4/24
 */
@SpringBootApplication
public class BeanLifeCycleTest {
    @Test
    public void testBean01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfigLifeCycle.class);
        System.out.println("容器已经启动成功...");
        applicationContext.removeBeanDefinition("bean1");
    }

    @Test
    public void testBean02() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfigLifeCycle.class);
        System.out.println("容器已经启动成功...");
        applicationContext.removeBeanDefinition("bean1");
        applicationContext.removeBeanDefinition("bean2");
        applicationContext.removeBeanDefinition("bean3");
        applicationContext.getBean("beanAware");
    }

    @Test
    public void test() {
        SpringApplication.run(BeanLifeCycleTest.class);
    }
}
