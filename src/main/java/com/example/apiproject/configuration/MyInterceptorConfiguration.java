package com.example.apiproject.configuration;

import com.example.apiproject.interceptor.AuthInterceptor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyInterceptorConfiguration implements WebMvcConfigurer {
    AuthInterceptor authInterceptor;

    @Autowired
    public void setAuthInterceptor(AuthInterceptor authInterceptor) {
        this.authInterceptor = authInterceptor;
    }

    @Override
    public void addInterceptors(@NotNull InterceptorRegistry registry) {
        registry
                .addInterceptor(authInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/auth/**",
                        "/dev/**",
                        "/css/**",
                        "/favicon.ico",
                        "/doc.html",
                        "/v3/api-docs",
                        "/v3/api-docs/**",
                        "/apiproject/swagger-ui.html",
                        "/doc.html",
                        "/doc.html#/**",
                        "/webjars/**"
                );
    }
}
