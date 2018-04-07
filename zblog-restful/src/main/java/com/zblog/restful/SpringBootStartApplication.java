package com.zblog.restful;

/**
 * Created by 石光.
 * Email: shiguang@sigon.me
 * Date: 2018/4/1
 * Time: 上午11:39
 * Project: zblog-restful
 */

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 修改启动类，继承 SpringBootServletInitializer 并重写 configure 方法
 */
public class SpringBootStartApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(Application.class);
    }
}
