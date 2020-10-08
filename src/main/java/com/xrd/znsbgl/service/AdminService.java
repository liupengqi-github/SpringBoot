package com.xrd.znsbgl.service;

import com.xrd.znsbgl.entity.Admin;

public interface AdminService {
    public Admin getAdminByUsername(String username);

    public int addAdmin(Admin admin);
}
