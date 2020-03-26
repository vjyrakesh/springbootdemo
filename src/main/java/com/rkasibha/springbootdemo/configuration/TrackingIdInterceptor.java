package com.rkasibha.springbootdemo.configuration;

import com.rkasibha.springbootdemo.interceptor.AddTrackingIdInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class TrackingIdInterceptor implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AddTrackingIdInterceptor());
    }
}
