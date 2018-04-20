package com.zblog.restful.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zblog.restful.dao.domain.User;
import com.zblog.restful.dao.mapper.UserMapper;
import com.zblog.restful.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 石光.
 * Email: shiguang@sigon.me
 * Date: 2018/4/2
 * Time: 下午8:39
 * Project: zblog-restful
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public List<User> find(String name){
        EntityWrapper<User> entityWrapper = new EntityWrapper<>();
        if(StringUtils.isNotBlank(name)) {
            entityWrapper.eq("user_name", name);
        }
        return this.selectList(entityWrapper);
    }

    @Override
    public User getUser(String name) {
        EntityWrapper<User> entityWrapper = new EntityWrapper<>();
        if (StringUtils.isNotBlank(name)) {
            entityWrapper.eq("user_name", name);
        }
        return this.selectOne(entityWrapper);
    }
}
