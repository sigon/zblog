package com.zblog.restful.web.controller;

import com.zblog.common.util.json.JsonUtil;
import com.zblog.restful.vo.ResultVO;

/**
 * @author bjyfshiguang
 * @project zblog-restful
 * @since 2018/4/11 17:58
 */
public class BaseController {
    Integer getUserId(){
        return null;
    }

    String jsonResult(Object data){
        return jsonResult(0, null, data);
    }
    String jsonResult(Integer code, String msg, Object data){
        return JsonUtil.write2JsonStr(new ResultVO(code, msg, data));
    }
}
