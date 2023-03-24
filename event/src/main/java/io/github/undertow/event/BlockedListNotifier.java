package io.github.undertow.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class BlockedListNotifier implements ApplicationListener<BlockedListEvent> {

    @Override
    public void onApplicationEvent(BlockedListEvent event) {
        // notify appropriate parties via notificationAddress...
        System.out.println(">>> : 该邮件地址属于黑名单中，处理一些黑名单业务..）: " + event.toString());
    }
}
