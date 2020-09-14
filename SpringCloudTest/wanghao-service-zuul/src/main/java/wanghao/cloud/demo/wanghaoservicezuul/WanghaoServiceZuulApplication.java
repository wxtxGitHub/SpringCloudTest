package wanghao.cloud.demo.wanghaoservicezuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @EnableZuulProxy 开启网关功能
 */
@SpringBootApplication
@EnableZuulProxy
public class WanghaoServiceZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(WanghaoServiceZuulApplication.class, args);
    }

}
