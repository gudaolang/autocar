package com.leren;

import com.leren.filter.ExceptionFilter;
import com.leren.filter.ServicesFallBackProvider;
import com.leren.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @author lee
 * @Date:15/03/2018
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableEurekaClient
@EnableFeignClients
@EnableZuulProxy
@EnableCircuitBreaker
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class);
    }

    @Bean
    public TokenFilter timeTakenFilter() {
        return new TokenFilter();
    }

    @Bean
    public ExceptionFilter exceptionFilter() {
        return new ExceptionFilter();
    }

    @Bean
    public ServicesFallBackProvider servicesFallBackProvider() {
        return new ServicesFallBackProvider();
    }
}
