package com.xrd.znsbgl.controller;

import com.xrd.znsbgl.entity.Admin;
import com.xrd.znsbgl.entity.Equipment;
import com.xrd.znsbgl.mapper.AdminMapper;
import com.xrd.znsbgl.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AdminController {
    @Autowired
    AdminMapper adminMapper;

    @Autowired
    AdminService adminService;

    @GetMapping("/getAllAdmin")
    public Map<String, Object> getAllAdmin () {
        Map<String, Object> map = new HashMap<String, Object>();
        ArrayList<Admin> al  = adminMapper.getAllAdmin();
        map.put("code", 1);
        map.put("msg", "查询成功");
        map.put("data",al);
        return map;
    }

    @PostMapping("/addAdmin")
    public Map<String, Object> addAdmin(Admin admin) {
        Map<String, Object> map = new HashMap<String, Object>();
        //判断用户名不能重复
        Admin a = adminService.getAdminByUsername(admin.getUsername());
        if (a!=null){
            map.put("code", 0);
            map.put("msg", "用户存在，注册失败");
        }else if (admin.getPassword().length()<6){
            map.put("code", 0);
            map.put("msg", "添加失败，密码不能小于6位");
        }
        else {
            int i = adminService.addAdmin(admin);
            map.put("code", i);
            map.put("msg", "插入成功");
        }
        return map;
    }
}
