package com.leren;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import com.util.RedisUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableCircuitBreaker
@EnableEurekaClient
@ComponentScan({"com.leren", "com.util"})
@EnableMethodCache(basePackages = "com.leren")
@EnableCreateCacheAnnotation
public class AuthApplication implements EmbeddedServletContainerCustomizer {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RedisUtil redisUtil() {
        return new RedisUtil();
    }

    /**
     * Customize the specified {@link ConfigurableEmbeddedServletContainer}.
     *
     * @param container the container to customize
     */
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setContextPath("/auth");
    }
}

