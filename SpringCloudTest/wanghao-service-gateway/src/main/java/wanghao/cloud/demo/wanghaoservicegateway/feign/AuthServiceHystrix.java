package wanghao.cloud.demo.wanghaoservicegateway.feign;

import org.springframework.stereotype.Component;
import wanghao.cloud.demo.wanghaolibcommon.R;

import java.util.Map;

/**
 * @Author WangHao
 * @Date: 2020/9/8 6:47 下午
 */
@Component
public class AuthServiceHystrix implements AuthServiceFeign{
    @Override
    public R ByFeignGet(Map<String, Object> params) {
        return R.error("服务器繁忙，请稍后重试 AuthServiceHystrix");
    }

    @Override
    public R ByFeignPost(Map<String, Object> params) {
        return R.error("服务器繁忙，请稍后重试 AuthServiceHystrix");
    }
}
