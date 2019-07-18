package cn.zhonggong.makeup.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 军辉
 * 2019-07-17 21:25*/


@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Value("${preread.uploadPath}")
    private String path;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**").addResourceLocations("file:///" + path);
    }
}
