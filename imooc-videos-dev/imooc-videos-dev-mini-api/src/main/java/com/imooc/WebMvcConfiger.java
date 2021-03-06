package com.imooc;

import com.imooc.controller.interceptor.MiniInterceptor;
import org.apache.tomcat.jni.OS;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by xyzzg on 2018/8/11.
 这里的意思是/** 表示匹配到的所有的静态资源，都会去G:/imoo-videos-resources/douyin/ 下的目录去进行查找，
 这里与在使用SSM在tomcat中的配置不同的是，使用SSM时在tomcat中映射为
 G:/imoo-videos-resources/douyin/ 是无法找到的，
 必须 配置为
 <Context docBase="G:/imooc-videos-resources/douyin/users" path="/users" />
 <Context docBase="G:/imooc-videos-resources/douyin/bgm" path="/bgm" />
 才能匹配到
 而使用springboot当我们映射为G:/imoo-videos-resources/douyin/ 。
 那么 douyin目录下的所有文件（夹）其实都是匹配到的。
 */
@Configuration
public class WebMvcConfiger extends WebMvcConfigurerAdapter{
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //资源映射
        String os_name = System.getProperty("os.name");
        if (os_name.toLowerCase().startsWith("win")){
            registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/META-INF/resources/")
                .addResourceLocations("file:D:/imooc_videos_dev/");
        } else{
            registry.addResourceHandler("/**")
                    .addResourceLocations("classpath:/META-INF/resources/")
                    .addResourceLocations("file:/home/imooc_videos_dev/");
        }

    }
    //初始化zk
    @Bean(initMethod = "init")
    public ZKCuratorClient zkCuratorClient() {
        return new ZKCuratorClient();
    }

    //自定义拦截器初始化
    @Bean
    public MiniInterceptor miniInterceptor() {
        return new MiniInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(miniInterceptor()).addPathPatterns("/user/**")
                .addPathPatterns("/video/upload", "/video/uploadCover",
                        "/video/userLike", "/video/userUnLike",
                        "/video/saveComment")
                .addPathPatterns("/bgm/**")
                .excludePathPatterns("/user/queryPublisher");

        super.addInterceptors(registry);
    }
}
