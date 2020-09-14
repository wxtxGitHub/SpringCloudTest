package wanghao.cloud.demo.wanghaoservicegateway.HttpClient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import wanghao.cloud.demo.wanghaolibcommon.R;

import java.util.Map;

@Component
public class AuthServiceByHttp {

    public static String AUTH_HASPERMISSION_URL = "http://localhost:8082/auth/hasPermission";


    public R byHttpGet(Map<String, Object> params) {
        String html = HttpRequestUtil.getData(AUTH_HASPERMISSION_URL + "?token=" + params.get("token").toString());
        return JSON.parseObject(html, R.class);
    }

    public R byHttpPost(Map<String, Object> params) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("token", params.get("token").toString());
        String html = HttpRequestUtil.postData(AUTH_HASPERMISSION_URL, jsonObject);
        return JSON.parseObject(html, R.class);
    }
}
