package wanghao.cloud.wanghaoserviceauth.controller;

/**
 * @Author WangHao
 * @Date: 2020/9/8 10:17 上午
 */

import com.netflix.client.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import wanghao.cloud.demo.wanghaolibcommon.R;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/hasPermission")
    public R hasPermission(@RequestBody Map<String, Object> params) throws InterruptedException {
        Object token = params.get("token");
        if (token != null && token.toString().length() > 5) {
            return R.ok("Post验证成功");
        }
//        else {
//            return R.error("验证失败");
//        }
        Thread.sleep(2000L);
        return R.error("验证失败");
    }

    @GetMapping("/hasPermission")
    public R hasPermissionByGet(@RequestParam Map<String, Object> params, HttpServletRequest request) {
        int port = request.getRemotePort();
        String host = request.getRemoteHost();
        int localPort = request.getLocalPort();

        Object token = params.get("token");
        if (token != null && token.toString().length() > 5) {
            return R.ok("Get验证成功 "+host+":"+localPort);
        } else {
            return R.error("验证失败 "+host+":"+localPort);
        }
    }

}
