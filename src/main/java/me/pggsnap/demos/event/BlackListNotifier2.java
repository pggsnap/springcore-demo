package me.pggsnap.demos.event;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author pggsnap
 * @date 2020/4/27
 */
@Component
public class BlackListNotifier2 {

    @Async
    @EventListener
    @Order(20)
    public void processBlackListEvent(BlackListEvent event) {
        System.out.println("BlackListNotifier2 async receives: " + event.toString());
    }
}
