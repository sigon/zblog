package com.zblog.restful.dao.mapper;

/**
 * Created by 石光.
 * Email: shiguang@sigon.me
 * Date: 2018/4/3
 * Time: 上午12:27
 * Project: zblog-restful
 */
public interface SuperMapper<T> extends com.baomidou.mybatisplus.mapper.BaseMapper<T> {

    // 这里可以写自己的公共方法、注意不要让 mp 扫描到误以为是实体 Base 的操作
}
