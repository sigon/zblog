package com.zblog.restful.dao.domain;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 石光.
 * Email: shiguang@sigon.me
 * Date: 2018/4/1
 * Time: 下午1:07
 * Project: zblog-restful
 */
@TableName("user")
public class User extends Model<User> {

    private Integer id;
    @TableField("login_name")
    private String loginName;
    @TableField("real_name")
    private String realName;
    private Integer status;
    @TableField("create_date")
    private Date createDate;
    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
