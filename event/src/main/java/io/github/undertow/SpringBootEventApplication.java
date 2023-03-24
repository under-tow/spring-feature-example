package io.github.undertow;

import io.github.undertow.annoation_event.BlockedFirstEvent;
import io.github.undertow.annoation_event.EmailService2;
import io.github.undertow.event.EmailService;
import io.github.undertow.util.SpringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableAsync
@SpringBootApplication
public class SpringBootEventApplication {
    public static void main(final String[] args) {

        SpringApplication.run(SpringBootEventApplication.class, args);
        testEvent();
        testAnnotationEvent();
    }

    /**
     * 测试事件发布
     */
    private static void testEvent() {
        System.out.println("---- 运行 testEvent -------");
        EmailService emailService = SpringUtils.getBean("emailService", EmailService.class);
        emailService.sendEmail("zhang@example.org", "hi zhang~");
        emailService.sendEmail("bob@example.org", "hi bob~");
    }

    /**
     * 测试事件发布 （注解版）
     */
    private static void testAnnotationEvent() {
        System.out.println("---- 运行 testAnnotationEvent -------");
        EmailService2 emailService2 = SpringUtils.getBean("emailService2", EmailService2.class);
        emailService2.sendEmail("zhang@example.org", "hi zhang~");
        emailService2.sendEmail("sun@example.org", "hi bob~");
        emailService2.sendEmail("sun@example.org", "hi sun~");
    }

}
