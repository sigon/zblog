package com.zblog.restful.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zblog.restful.dao.domain.Blog;
import com.zblog.restful.dao.mapper.BlogMapper;
import com.zblog.restful.service.BlogService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author bjyfshiguang
 * @project zblog-restful
 * @since 2018/4/11 15:13
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService{

    @Override
    public Page<Blog> findByUserId(Integer userId, Integer status, Page<Blog> page){
        EntityWrapper<Blog> entityWrapper = new EntityWrapper<>();
        if(userId != null) {
            entityWrapper.eq("userId", userId);
        }
        if(status != null){
            entityWrapper.eq("status", status);
        }
        return this.selectPage(page, entityWrapper);
    }

    @Override
    public Blog readById(Integer id){
        Blog blog = selectById(id);
        if(blog == null || blog.getStatus() != 1){
            return null;
        }
        return blog;
    }

    @Override
    public void add(Blog blog){
        blog.setCreatedDate(new Date());
        this.insert(blog);
    }

    @Override
    public void delete(Integer id){
        this.deleteById(id);
    }

    public void update(Blog blog){
        blog.setModifiedDate(new Date());
        this.updateById(blog);
    }

}
