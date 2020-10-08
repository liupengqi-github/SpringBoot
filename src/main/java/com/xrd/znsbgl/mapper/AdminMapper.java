package com.xrd.znsbgl.mapper;

import com.xrd.znsbgl.entity.Admin;
import com.xrd.znsbgl.entity.Equipment;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface AdminMapper {
    public Admin getAdminById(Integer id);
    public ArrayList<Admin> getAllAdmin();
    public int addAdmin (Admin admin);

    public Admin getAdminByUsername(String username);
}
