package io.github.undertow.event;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService implements ApplicationEventPublisherAware {

    // 邮箱黑名单
    private final List<String> blockedList = List.of("sun@example.org");

    private ApplicationEventPublisher publisher;

    /**
     * 这里是实现接口注入了applicationEventPublisher
     * 也可以不实现接口，直接 @Autowire注入 applicationEventPublisher 变量
     *
     * @param applicationEventPublisher
     */
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    public void sendEmail(String address, String content) {
        // 地址属于黑名单则推送 BlockedListEvent 事件，否则发送邮件
        if (blockedList.contains(address)) {
            publisher.publishEvent(new BlockedListEvent(this, address, content));
        } else {
            // send email...
            System.out.println(">>> 发送邮件: " + address);
        }
    }
}
