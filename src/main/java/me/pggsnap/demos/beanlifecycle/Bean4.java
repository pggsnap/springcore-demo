package me.pggsnap.demos.beanlifecycle;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author pggsnap
 * @date 2020/4/27
 */
@Component
@Lazy
public class Bean4 {
    public Bean4() {
        System.out.println("bean4 constructor...");
    }
}
