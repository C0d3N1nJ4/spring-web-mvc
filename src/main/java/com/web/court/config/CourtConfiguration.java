package com.web.court.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * The @ComponentScan annotation tells Spring to look for other components, configurations,
 * and services in the com.example.web package, allowing it to find the controllers and register the detected beans
 * @EnabledWebMvc is used to enable Spring MVC and does additional setup for Spring MVC
 *
 */
@Configuration
@ComponentScan("com.web.court")
@EnableWebMvc
public class CourtConfiguration {

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        var viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
