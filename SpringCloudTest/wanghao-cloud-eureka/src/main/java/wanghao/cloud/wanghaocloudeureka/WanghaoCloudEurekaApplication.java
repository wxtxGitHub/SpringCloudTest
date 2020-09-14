package wanghao.cloud.wanghaocloudeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class WanghaoCloudEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(WanghaoCloudEurekaApplication.class, args);
    }

}
