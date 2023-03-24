package io.github.undertow.annoation_event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService2 {

    // 邮箱黑名单
    private final List<String> blockedList = List.of("sun@example.org");

    private ApplicationEventPublisher publisher;

    /**
     * 构造方法注入bean，或者autowire也可以
     *
     * @param publisher
     */
    public EmailService2(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void sendEmail(String address, String content) {

        // 地址属于黑名单则推送 BlockedListEvent 事件，否则发送邮件
        if (blockedList.contains(address)) {
            // async event
            publisher.publishEvent(new BlockedAsyncEvent(this, address, content));
            // normal event
            publisher.publishEvent(new BlockedFirstEvent(this, address, content));
        } else {
            // send email...
            System.out.println(">>> 发送邮件: " + address);
        }
    }
}
