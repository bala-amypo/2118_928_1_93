package com.example.demo.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.demo.servlet.SimpleHelloServlet;

@Configuration
public class WebConfig {
    
    @Bean
    public ServletRegistrationBean<SimpleHelloServlet> helloServletRegistration() {
        ServletRegistrationBean<SimpleHelloServlet> registration = 
            new ServletRegistrationBean<>(new SimpleHelloServlet());
        registration.addUrlMappings("/hello");
        return registration;
    }
}