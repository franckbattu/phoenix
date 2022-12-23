package dev.narradium.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

@Configuration
public class LocaleConfig {
    
    @Bean
    public LocaleResolver localeResolver() {
        AppLocaleResolver appLocaleResolver = new AppLocaleResolver();
        return appLocaleResolver;
    }
}
