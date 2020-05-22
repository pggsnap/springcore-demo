package me.pggsnap.demos.validation;

import org.junit.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author pggsnap
 * @date 2020/5/4
 */
@SpringBootApplication
public class ValidationTest {
    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ValidationTest.class);
        System.out.println("容器已经启动成功...");
        PersonController personController = applicationContext.getBean("personController", PersonController.class);
        Person p = new Person();
        p.setName("zhsan");
        personController.check(p);
    }
}
