package com.study.gatewaydemo.filters;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import reactor.core.publisher.Mono;
/**
 * @Classname RateLimiterConfig
 * @Description 限流方法 该配置方法和UriKeyResolver的@Component 注解配置方式只要一个就可以了，否则会冲突
 */
@Configuration
public class RateLimiterConfig {
    @Bean(value = "uriKeyResolver")
    public KeyResolver remoteAddrKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getPath().value());
    }
    /*
    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public CustomGatewayBlockExceptionHandler sentinelGatewayBlockExceptionHandler() {
        // Register the custom block exception handler .
        return new CustomGatewayBlockExceptionHandler(viewResolvers, serverCodecConfigurer);
    }*/
}