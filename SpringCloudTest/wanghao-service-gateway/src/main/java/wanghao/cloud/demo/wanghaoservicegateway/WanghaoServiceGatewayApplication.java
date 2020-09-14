package wanghao.cloud.demo.wanghaoservicegateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCircuitBreaker
@EnableFeignClients
/**
 * @EnableCircuitBreaker 熔断器
 * @EnableFeignClients      Feign 代理
 */
public class WanghaoServiceGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(WanghaoServiceGatewayApplication.class, args);
    }


    /**
     * 添加@LoadBalanced以后RestTemplate就具有了负载均衡的功能
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
