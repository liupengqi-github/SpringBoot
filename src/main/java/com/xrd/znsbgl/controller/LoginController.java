package com.xrd.znsbgl.controller;

import com.xrd.znsbgl.entity.Admin;
import com.xrd.znsbgl.entity.LoginLog;
import com.xrd.znsbgl.mapper.LogMapper;
import com.xrd.znsbgl.mapper.LoginMapper;
import com.xrd.znsbgl.service.LogService;
import com.xrd.znsbgl.service.LoginService;
import com.xrd.znsbgl.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin//允许跨越注解
@RestController  //页面跳转建一个controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    LogService logService;

    @GetMapping("/login")
    public Map<String,Object> login(Admin admin, String ip, HttpSession httpSession){

        Map<String,Object> map = new HashMap<String, Object>();
        //查询数据，   正确返回1    错误返回0
        //Admin a = loginMapper.login(admin);
        Admin a =loginService.getAdminByUP(admin);
        if (a==null){
            map.put("code",0);
            map.put("msg","登录失败,用户名或密码错误");
        }else {
            //写入登录日志
            logService.addLog(a.getId(),ip);
            map.put("code",1);
            map.put("msg","登录成功");
            //生成秘钥，写入session
            Date d = new Date();

            String token = MD5Util.md5(a.getUsername()+d.getTime());
            httpSession.setAttribute(token,a.getUsername());
            httpSession.setMaxInactiveInterval(60*60);
            map.put("token",token);
        }
        return map;

    }
    @GetMapping("getToken")
    public Map<String,Object> getToken(String token,HttpSession httpSession){

        Map<String,Object> map = new HashMap<String, Object>();
        if (httpSession.getAttribute(token)!=null){
            map.put("code",1);
            String username = (String) httpSession.getAttribute(token);
            map.put("user",username);
        }else {
            map.put("code",0);
        }
        return map;
    }
    @GetMapping("deleteToken")
    public Map<String,Object> deleteToken(String token,HttpSession httpSession){

        Map<String,Object> map = new HashMap<String, Object>();
        httpSession.removeAttribute(token);
            map.put("code",1);
        return map;
    }
}
