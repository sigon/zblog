package com.zblog.restful.web.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.zblog.common.util.json.JsonUtil;
import com.zblog.restful.constants.Constants;
import com.zblog.restful.dao.domain.User;
import com.zblog.restful.dao.mapper.UserMapper;
import com.zblog.restful.service.UserService;
import com.zblog.restful.vo.ResultVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * FileName: SignController
 * Author:   houchao
 * Date:     2018/4/15 下午08:50
 * Description: 登录注册的Controller
 */

@RestController
@RequestMapping("/")
public class SignController extends BaseController {


    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    /**
     * 功能描述: 用户注册功能
     * 对用户输入的用户名进行校验，若存在，则提示已注册
     * 若不存在，则进行添加操作
     *
     * @param user
     * @param request
     * @return string
     */
    @RequestMapping("/signUp")
    public String signUp(User user, HttpServletRequest request) {
        ResultVO resultVO = new ResultVO();
        if (StringUtils.isNotBlank(user.getUserName())) {
            ResultVO res = checkUser(user.getUserName());
            if (Constants.SUCCESS == res.getCode()) {
                /*如果用户已存在，提示已注册*/
                resultVO.setCode(Constants.FAIL);
                resultVO.setMsg(Constants.USER_REPEAT);
            } else {
                /*如果未注册，则insert User*/
                if (StringUtils.isNotBlank(user.getPassword())) {
                    String encryPwd = String.valueOf(DigestUtils.md5Digest(user.getPassword().getBytes()));
                    user.setPassword(encryPwd);
//                    Integer result = userMapper.insert(user);
                    boolean result = user.insert();
                    if (result) {
                        resultVO.setCode(Constants.SUCCESS);
                        resultVO.setMsg(Constants.REG_SUCCESS);
                    }
                } else {
                    resultVO.setCode(Constants.FAIL);
                    resultVO.setMsg(Constants.PWD_NONE);
                }
            }
        }

        return JsonUtil.write2JsonStr(resultVO);
    }

    /**
     * 功能描述:
     * 用户登录
     * 1、对用户名进行判断，存在与否
     * 2、存在的话对密码进行md5加密校验
     *
     * @param userName
     * @param password
     * @param request
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("signIn")
    public String signIn(String userName, String password, HttpServletRequest request) {
        //首先对userName进行check
        ResultVO resultVO = new ResultVO();
        ResultVO res = checkUser(userName);
        if (Constants.SUCCESS == res.getCode()) {
            /*1、如果用户存在，就对pwd进行验证*/
            User user = (User) res.getData();
            String encryPwd = String.valueOf(DigestUtils.md5Digest(password.getBytes()));
            if (user.getPassword().equals(encryPwd)) {
                resultVO.setCode(Constants.SUCCESS);
                resultVO.setMsg(Constants.LOGIN_SUCCESS);
                //userId放入到session中，方便下次获取
                HttpSession session = request.getSession();
                session.setAttribute("userId", user.getId());
                session.setMaxInactiveInterval(-1);
            } else {
                resultVO.setCode(Constants.FAIL);
                resultVO.setMsg(Constants.LOGIN_FAIL);
            }
        } else {
            /*2、如果不存在，则提示用户不存在*/
            resultVO.setCode(Constants.FAIL);
            resultVO.setMsg(Constants.USER_NONE);
        }
        return JsonUtil.write2JsonStr(resultVO);
    }

    /**
     * 功能描述: 根据userName检查用户是否存在
     * 存在：code=0
     * 不存在：code=1
     *
     * @param userName
     * @return string
     */
    @RequestMapping("/checkUser")
    public ResultVO checkUser(String userName) {
        ResultVO resultVO = new ResultVO();
        //如果是登录页面，检查用户是否存在
        User user = userService.getUser(userName);
        if (null != user) {
            resultVO.setMsg(Constants.USER_EXIST);
            resultVO.setCode(Constants.SUCCESS);
            resultVO.setData(user);
        } else {
            resultVO.setMsg(Constants.USER_NONE);
            resultVO.setCode(Constants.FAIL);
        }
        return resultVO;
    }


}
