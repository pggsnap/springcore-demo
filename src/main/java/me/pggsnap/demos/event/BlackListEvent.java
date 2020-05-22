package me.pggsnap.demos.event;

import org.springframework.context.ApplicationEvent;

import java.util.StringJoiner;

/**
 * @author pggsnap
 * @date 2020/4/27
 */
public class BlackListEvent extends ApplicationEvent {
    private final String address;
    private final String content;

    public BlackListEvent(Object source, String address, String content) {
        super(source);
        this.address = address;
        this.content = content;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BlackListEvent.class.getSimpleName() + "[", "]")
                .add("address='" + address + "'")
                .add("content='" + content + "'")
                .toString();
    }
}
