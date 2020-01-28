package org.pushingbarriers.bgsystem.configuration;

import org.pushingbarriers.bgsystem.interceptor.AuthorizationInterceptor;
import org.pushingbarriers.bgsystem.util.ImagePath;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthorizationInterceptor()).addPathPatterns("/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        //config virtual picture path, map '/image/' to '/Users/XXX/Desktop/'
        //registry.addResourceHandler("/image/**").addResourceLocations("File:"+ImagePath.IMAGE_PATH);
    }
}
