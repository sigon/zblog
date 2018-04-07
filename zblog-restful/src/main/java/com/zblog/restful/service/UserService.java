package com.zblog.restful.service;

import com.zblog.restful.dao.domain.User;

import java.util.List;

/**
 * Created by 石光.
 * Email: shiguang@sigon.me
 * Date: 2018/4/2
 * Time: 下午8:39
 * Project: zblog-restful
 */
public interface UserService {
    List<User> find(String name);
}
