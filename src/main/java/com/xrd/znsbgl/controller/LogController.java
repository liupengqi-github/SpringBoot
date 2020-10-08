package com.xrd.znsbgl.controller;

import com.xrd.znsbgl.entity.Admin;
import com.xrd.znsbgl.entity.LoginLog;
import com.xrd.znsbgl.mapper.AdminMapper;
import com.xrd.znsbgl.mapper.LogMapper;
import com.xrd.znsbgl.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin//允许跨越注解
@RestController  //页面跳转建一个controller
public class LogController {

    @Autowired
    LogMapper logMapper;
    @Autowired
    AdminMapper adminMapper;
    //我们写一个方法   来获取所有日志的信息
    @GetMapping("/getAllLog")
    public Map<String, Object> getAllLog() {
        Map<String, Object> map = new HashMap<String, Object>();
        ArrayList<LoginLog> al = logMapper.getAllLoginLog();
        System.out.println(al);
        for (int i=0;i<al.size();i++){
            int adminid = al.get(i).getAdminid();
            al.get(i).setAdmin(adminMapper.getAdminById(adminid));
        }
        System.out.println(al);

        map.put("data",al);
        map.put("code",1);
        map.put("msg","查询成功");

        return map;
    }
}
