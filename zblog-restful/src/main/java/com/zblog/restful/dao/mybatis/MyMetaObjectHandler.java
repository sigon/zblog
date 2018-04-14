package com.zblog.restful.dao.mybatis;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import com.zblog.restful.Application;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by 石光.
 * Email: shiguang@sigon.me
 * Date: 2018/4/2
 * Time: 下午9:11
 * Project: zblog-restful
 */
@Component
public class MyMetaObjectHandler extends MetaObjectHandler {

    protected final static Logger logger = LoggerFactory.getLogger(Application.class);

    @Override
    public void insertFill(MetaObject metaObject) {
        logger.info("新增的时候干点不可描述的事情");
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        logger.info("更新的时候干点不可描述的事情");
    }
}
