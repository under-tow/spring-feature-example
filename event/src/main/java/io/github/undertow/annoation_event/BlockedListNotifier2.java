package io.github.undertow.annoation_event;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


@Component
public class BlockedListNotifier2 {


    @Async("EventExecutorPool")
    @EventListener
    public void onApplicationEvent(BlockedAsyncEvent event) throws InterruptedException {
        Log log = LogFactory.getLog(getClass());
        log.info(">>> wait 6s , " + event.getAddress());
        TimeUnit.SECONDS.sleep(6);
        System.out.println(">>> BlockedAsyncEvent： : 异步业务 ）: " + event);
    }


    /**
     * EventListener 注解 默认支持按方法参数匹配Event，也手动通过class指定Event
     */
    @EventListener(BlockedFirstEvent.class)
    public BlockedSecondEvent onApplicationEvent(BlockedFirstEvent event) {
        System.out.println(">>> BlockedFirstEvent：: 该邮件地址属于黑名单中..，处理业务1）: " + event.toString());
        return new BlockedSecondEvent(this, event.getAddress(), event.getContent());
    }


    /**
     * EventListener 注解 支持SPEL表达式条件过滤
     * 这里只处理邮件内容 = 'hi sun~' 的事件
     */
    @EventListener(condition = "#event.content == 'hi sun~'")
    public void onApplicationEvent(BlockedSecondEvent event) {
        System.out.println(">>> BlockedSecondEvent： 内容包括 hi sun~: 处理业务2 ）: " + event.toString());
    }


}
