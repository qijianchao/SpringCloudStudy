package com.study.gatewaydemo.filters;

import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;

public class CustomGatewayBlockExceptionHandler implements WebExceptionHandler {

    /**
     * 重写限流响应，改造成JSON格式的响应数据
     */
    private Mono<Void> writeResponse(ServerResponse response, ServerWebExchange exchange) {
        ServerHttpResponse serverHttpResponse = exchange.getResponse();
        serverHttpResponse.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        String resultString = "{\"status-code\":200,\"msg\":\"自定义\"}";
        DataBuffer buffer = serverHttpResponse.bufferFactory().wrap(resultString.getBytes());
        return serverHttpResponse.writeWith(Mono.just(buffer));
    }

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        if (exchange.getResponse().isCommitted()) {
            return Mono.error(ex);
        } else {
            return Mono.error(ex);
        }
    }

}

