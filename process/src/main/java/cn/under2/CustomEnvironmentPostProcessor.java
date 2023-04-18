package cn.under2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

@Configuration
public class CustomEnvironmentPostProcessor implements EnvironmentPostProcessor {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        Map<String, Object> systemProperties = environment.getSystemProperties();
        System.out.println("systemProperties = " + systemProperties);
        System.out.println(">> implements EnvironmentPostProcessor");
    }
}
