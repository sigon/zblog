package com.zblog.restful.vo;

/**
 * @author bjyfshiguang
 * @project zblog-restful
 * @since 2018/4/11 18:49
 */
public class ResultVO {
    private Integer code;
    private String msg;
    private Object data;

    public ResultVO() {
    }

    public ResultVO(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
