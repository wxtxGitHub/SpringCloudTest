package wanghao.cloud.demo.wanghaoservicegateway.restTempate;

import com.google.j2objc.annotations.AutoreleasePool;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import wanghao.cloud.demo.wanghaolibcommon.R;

import java.util.Map;

/**
 * @Author WangHao
 * @Date: 2020/9/8 2:38 下午
 */
@Component
public class AuthServiceByTemplate {
    @Autowired
    LoadBalancerClient balancerClient;
    @Autowired
    RestTemplate restTemplate;

    public static String AUTH_HASPERMISSION_URL = "http://localhost:8082/auth/hasPermission";


    public R ByTemplate(Map<String, Object> params) {
        return new RestTemplate().postForObject(AUTH_HASPERMISSION_URL, params, R.class);
    }

    public R ByBalancer(Map<String, Object> params) {
//        他会通过负载均衡算法从所有的service-auth实例中选择一个
        ServiceInstance instance = balancerClient.choose("service-auth");
        String ip = instance.getHost();
        int port = instance.getPort();
        String url = String.format("http://%s:%d/auth/hasPermission", ip, port);
        return new RestTemplate().postForObject(url, params, R.class);
    }

    public R ByBalancerBetter(Map<String, Object> params) {
        String url = "http://service-auth/auth/hasPermission";
        return restTemplate.postForObject(url, params, R.class);
    }

    /**
     * @param params
     * @return
     * @@HystrixCommand(fallbackMethod = "getError")  熔断器，执行之前拦截，进行状态判断
     * getError 熔断回调方法
     */
    @HystrixCommand(fallbackMethod = "getError")
    public R ByHystrix(Map<String, Object> params) {
        String url = "http://service-auth/auth/hasPermission";
        return restTemplate.postForObject(url, params, R.class);
    }

    public R getError(Map<String, Object> params) {
        return R.error("服务器繁忙，请稍后重试。");
    }

}
