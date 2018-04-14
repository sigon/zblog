package com.zblog.restful.web.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.zblog.restful.dao.domain.Blog;
import com.zblog.restful.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bjyfshiguang
 * @project zblog-restful
 * @since 2018/4/11 17:53
 */
@RestController
@RequestMapping("/manage/blog")
public class BlogManageController extends BaseController {

    @Autowired
    private BlogService blogService;

    @RequestMapping("/list")
    public String list(){
        Integer userId = getUserId();
        return jsonResult(blogService.findByUserId(userId, null, new Page<>()));
    }

    @RequestMapping("/get")
    public String get(Integer id){
        return jsonResult(blogService.readById(id));
    }

    @RequestMapping("/delete")
    public String delete(Integer id){
        blogService.delete(id);
        return jsonResult(null);
    }

    @RequestMapping("/update")
    public String update(Blog blog){
        blogService.update(blog);
        return jsonResult(null);
    }

    @RequestMapping("/save")
    public String save(Blog blog){
        blogService.add(blog);
        return jsonResult(null);
    }
}
