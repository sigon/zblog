package com.zblog.restful.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.zblog.restful.dao.domain.Blog;

/**
 * @author bjyfshiguang
 * @project zblog-restful
 * @since 2018/4/11 15:14
 */
public interface BlogService {

    Page<Blog> findByUserId(Integer userId, Integer status, Page<Blog> page);

    Blog readById(Integer id);

    void add(Blog blog);

    void delete(Integer id);

    void update(Blog blog);
}
