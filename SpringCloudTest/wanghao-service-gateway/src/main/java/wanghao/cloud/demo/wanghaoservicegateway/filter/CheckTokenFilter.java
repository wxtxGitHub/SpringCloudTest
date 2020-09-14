package wanghao.cloud.demo.wanghaoservicegateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wanghao.cloud.demo.wanghaolibcommon.R;
import wanghao.cloud.demo.wanghaoservicegateway.HttpClient.AuthServiceByHttp;
import wanghao.cloud.demo.wanghaoservicegateway.feign.AuthServiceFeign;
import wanghao.cloud.demo.wanghaoservicegateway.restTempate.AuthServiceByTemplate;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author WangHao
 * @Date: 2020/9/8 11:26 上午
 */
@RestController
@RequestMapping("/checkToken")
public class CheckTokenFilter {

    @Autowired
    AuthServiceByHttp authServiceByHttp;

    @Autowired
    AuthServiceByTemplate template;

    @Resource
    AuthServiceFeign feign;


    @GetMapping("/byHttpGet")
    public R byHttpGet(@RequestParam Map<String, Object> params) {
        return authServiceByHttp.byHttpGet(params);
    }

    @GetMapping("/byHttpPost")
    public R byHttpPost(@RequestParam Map<String, Object> params) {
        return template.ByTemplate(params);
    }

    @GetMapping("/byBalancer")
    public R ByBalancer(@RequestParam Map<String, Object> params) {
        return template.ByBalancer(params);
    }

    @GetMapping("/ByBalancerBetter")
    public R ByBalancerBetter(@RequestParam Map<String, Object> params) {
        return template.ByBalancerBetter(params);
    }

    // 添加了熔断器
    @GetMapping("/ByHystrix")
    public R ByHystrix(@RequestParam Map<String, Object> params) {
        return template.ByHystrix(params);
    }

    // 使用Feign调用
    @GetMapping("/ByFeignGet")
    public R ByFeignGet(@RequestParam Map<String, Object> params) {
        return feign.ByFeignGet(params);
    }

    @GetMapping("/ByFeignPost")
    public R ByFeignPost(@RequestParam Map<String, Object> params) {
        return feign.ByFeignPost(params);
    }

}
