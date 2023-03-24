
## Event

>标准和自定义事件
[Go-> 官方文档 1.15.2. Standard and Custom Events](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#context-functionality-events)


### 原始版本 `io.github.undertow.event`

- 自定义事件 （ extends ApplicationEvent）
  `public class BlockedListEvent extends ApplicationEvent`
- 自定义监听器 （implements ApplicationListener<>）
  `public class BlockedListListener implements ApplicationListener<BlockedListEvent>`
- 事件发布者 （implements ApplicationEventPublisherAware）
  `public class EmailService implements ApplicationEventPublisherAware`

---> ApplicationEventPublisher -----Event----> ApplicationListener ---> doSomething~

### 基于注解版本 `io.github.undertow.annoation_event`

- 自定义事件  `extends ApplicationEvent）`
- 自定义监听器 `@EventListener`
- 事件发布者  `@Autowire ApplicationEventPublisher `


