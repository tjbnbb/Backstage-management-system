package com.tjb.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    @CrossOrigin
    @PostMapping(value = "/user/login")
    @ResponseBody
    public Map login() {
        HashMap<String, Object> response = new HashMap<>();
        HashMap<String, Object> responseData = new HashMap<>();
        responseData.put("token",1);
        response.put("code",20000);
        response.put("msg","success");
        response.put("data",responseData);
        return response;
    }

    @CrossOrigin
    @GetMapping(value = "/user/info")
    @ResponseBody
    public Map info() {
        HashMap<String, Object> responseInfo = new HashMap<>();
        HashMap<String, Object> responseData = new HashMap<>();
        responseData.put("roles","admin");
        responseData.put("name","Super admin,TJB");
        responseData.put("avatar","https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01237b5cd29ca8a801208f8b799f9b.gif&refer=http%3A%2F%2Fimg.zcool.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1636955518&t=17b1a571de56d3527a6d79b65f011672");
        responseInfo.put("code",20000);
        responseInfo.put("msg","success");
        responseInfo.put("data",responseData);
        return responseInfo;
    }

    @CrossOrigin
    @PostMapping(value = "/user/logout")
    @ResponseBody
    public Map logout() {
        HashMap<String, Object> response = new HashMap<>();
        HashMap<String, Object> responseData = new HashMap<>();
        response.put("code",20000);
        response.put("msg","success");
        return response;
    }
}
