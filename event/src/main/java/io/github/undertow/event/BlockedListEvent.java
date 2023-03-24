package io.github.undertow.event;

import org.springframework.context.ApplicationEvent;

public class BlockedListEvent extends ApplicationEvent {

    private final String address;
    private final String content;

    public BlockedListEvent(Object source, String address, String content) {
        super(source);
        this.address = address;
        this.content = content;
    }

    @Override
    public String toString() {
        return "BlockedListEvent{" +
                "address='" + address + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
