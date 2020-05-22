package me.pggsnap.demos.event;

import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author pggsnap
 * @date 2020/4/27
 */
@Component
@Order(10)
public class BlackListNotifier implements ApplicationListener<BlackListEvent> {

    @Override
    public void onApplicationEvent(BlackListEvent event) {
        System.out.println("BlackListNotifier sync receives: " + event);
    }
}
