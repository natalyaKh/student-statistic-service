package com.example.gatewayservice;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
public class ProxyConfig {
    @Bean
    RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("statistic_route",
                route -> route.path("/statistic-service/**")
                    .and()
                    .method(HttpMethod.GET)
                    .filters(filter -> filter.stripPrefix(1)
                    )
                    .uri("lb://STATISTIC-SERVICE"))
            .route("student-route",
                route -> route.path("/student-service/**")
                    .filters(filter -> filter.stripPrefix(1)
                    )
                    .uri("lb://STUDENT-SERVICE"))
            .route("article",
                route -> route.path("/article/**")
                    .filters(filter -> filter.stripPrefix(1)
                    )
                    .uri("lb://ARTICLE-SERVICE"))
            .build();
    }
}
