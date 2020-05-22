package me.pggsnap.demos.event;

import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalTime;
import java.util.Arrays;

/**
 * @author pggsnap
 * @date 2020/4/27
 */
@SpringBootApplication
public class EventTest {
    @Test
    public void test() {
        ConfigurableApplicationContext context = SpringApplication.run(EventTest.class);
        EmailService emailService = context.getBean("emailService", EmailService.class);
        emailService.setBlackList(Arrays.asList("a@example.org", "b@example.org"));
        emailService.sendEmail("b@example.org", "hello");
    }

    @Test
    public void time() {
        LocalTime time = LocalTime.now();
        System.out.println (time.isBefore(LocalTime.of(19, 20)));
        String flags = "check";
        System.out.println(flags.substring(flags.lastIndexOf(",") + 1));
    }
}
