package com.dongya.study.springcloud;

import com.dongya.study.springcloud.filter.IpFilter;
import com.dongya.study.springcloud.filter.TokenFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Filter配置
 */
@Configuration
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean IpFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new IpFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("ipFilter");
        registration.setOrder(1);
        return registration;
    }

    @Bean
    public FilterRegistrationBean tokenFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new TokenFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("tokenFilter");
        registration.setOrder(2);
        return registration;
    }
}
