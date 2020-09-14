package wanghao.cloud.demo.wanghaoservicegateway.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import wanghao.cloud.demo.wanghaolibcommon.R;

import java.util.Map;

/**
 * @Author WangHao
 * @Date: 2020/9/8 6:21 下午
 */
@FeignClient(name = "service-auth", fallback = AuthServiceHystrix.class)
public interface AuthServiceFeign {

    @GetMapping("/auth/hasPermission")
    R ByFeignGet(@RequestParam Map<String, Object> params);

    @PostMapping("/auth/hasPermission")
    R ByFeignPost(@RequestBody Map<String, Object> params);
}
