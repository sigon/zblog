package com.zblog.restful.controller;

import com.zblog.common.util.json.JsonUtil;
import com.zblog.restful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 石光.
 * Email: shiguang@sigon.me
 * Date: 2018/4/1
 * Time: 上午11:00
 * Project: zblog-restful
 */
@RestController
public class DemoController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/greeting")
    public String greeting(String name){
        return JsonUtil.write2JsonStr(userService.find(name));
    }
}
