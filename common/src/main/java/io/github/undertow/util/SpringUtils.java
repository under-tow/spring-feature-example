package io.github.undertow.util;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class SpringUtils implements BeanFactoryPostProcessor {

    private static ConfigurableListableBeanFactory beanFactory;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        beanFactory = configurableListableBeanFactory;
    }

    public static Object getBean(String beanName){
        return beanFactory.getBean(beanName);
    }

    public static <T>  T getBean(String beanName,Class<T> clazz){
        return beanFactory.getBean(beanName,clazz);
    }
}
