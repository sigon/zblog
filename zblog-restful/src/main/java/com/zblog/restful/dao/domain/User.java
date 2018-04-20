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

//    @TableField("id")
    private Integer id;
    @TableField("user_name")
    private String userName;
    @TableField("email")
    private String email;
    @TableField("password")
    private String password;
    @TableField("state")
    private String state;
    @TableField("create_date")
    private Date createDate;
    @TableField("modify_date")
    private Date modify_date;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModify_date() {
        return modify_date;
    }

    public void setModify_date(Date modify_date) {
        this.modify_date = modify_date;
    }
}
