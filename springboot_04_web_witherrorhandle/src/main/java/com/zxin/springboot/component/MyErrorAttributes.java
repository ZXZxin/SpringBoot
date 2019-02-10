package com.zxin.springboot.component;


import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

// 给容器中加入我们自己定义的ErrorAttributes
@Component
public class MyErrorAttributes extends DefaultErrorAttributes{


    // 返回值的map就是页面和json能获取的所有字段
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("company", "zxzxin"); //加上自己的字段 // 改变默认行为

        // 我们的异常处理器携带的数据
        Map<String, Object>extMap = (Map<String, Object>) webRequest.getAttribute("extMap", 0); // int SCOPE_REQUEST = 0; SCOPE_SESSION = 1;
        map.put("extMap", extMap);
        return map;
    }
}
