package com.xrd.znsbgl.service;

import com.xrd.znsbgl.entity.Admin;

public interface LoginService {
    //通过用户名和密码，获得用户详细信息
    public Admin getAdminByUP(Admin admin);
}
