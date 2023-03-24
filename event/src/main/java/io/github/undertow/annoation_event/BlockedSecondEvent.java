package io.github.undertow.annoation_event;

import org.springframework.context.ApplicationEvent;

public class BlockedSecondEvent extends ApplicationEvent {


    private final String address;
    private final String content;

    public BlockedSecondEvent(Object source, String address, String content) {
        super(source);
        this.address = address;
        this.content = content;
    }

    /**
     * 因为在监听器中 需要判断content内容，所以这里需要有getter方法
     * @EventListener(condition = "#event.content == 'hi sun~'")
     *
     */
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
