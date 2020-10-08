package com.xrd.znsbgl.service.serviceImpl;

import com.xrd.znsbgl.entity.Admin;
import com.xrd.znsbgl.mapper.LoginMapper;
import com.xrd.znsbgl.service.LoginService;
import com.xrd.znsbgl.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl  implements LoginService {
    @Autowired
    LoginMapper loginMapper;
    @Override
    public Admin getAdminByUP(Admin admin) {
        //处理密码

        admin.setPassword( MD5Util.md5(admin.getPassword()));
        Admin a = loginMapper.login(admin);
        return a;
    }
}
