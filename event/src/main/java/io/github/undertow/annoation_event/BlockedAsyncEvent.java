package io.github.undertow.annoation_event;

import org.springframework.context.ApplicationEvent;

public class BlockedAsyncEvent extends ApplicationEvent {


    private final String address;
    private final String content;

    public BlockedAsyncEvent(Object source, String address, String content) {
        super(source);
        this.address = address;
        this.content = content;
    }

    public String getAddress() {
        return address;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "BlockedListEvent{" +
                "address='" + address + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
