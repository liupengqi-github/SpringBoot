package com.xrd.znsbgl.controller;

import com.xrd.znsbgl.entity.Equipment;
import com.xrd.znsbgl.mapper.EquipmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class EquipmentController {
    @Autowired
    EquipmentMapper equipmentMapper;

    @GetMapping("/addEquipment")
    public Map<String, Object> getAllLog(Equipment equipment) {
        Map<String, Object> map = new HashMap<String, Object>();
        int i = equipmentMapper.addEquipment(equipment);
        map.put("code", 1);
        map.put("msg", "插入成功");
        return map;
    }

    @GetMapping("/getAllEquipment")
    public Map<String, Object> getAllLog() {
        Map<String, Object> map = new HashMap<String, Object>();
        ArrayList<Equipment> al = equipmentMapper.getAllEquipment();
        map.put("data",al);
        map.put("code",1);
        map.put("msg","查询成功");
        return map;
    }
    @GetMapping("/getEquipmentById")
    public Map<String, Object>getEquipmentById (Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        Equipment equipment = equipmentMapper.getEquipmentById(id);
        map.put("data", equipment);
        map.put("code", 1);
        map.put("msg", "查询成功");
        return map;
    }
    @GetMapping("/updateEquipmentById")
    public Map<String, Object>updateEquipmentById (Equipment equipment) {
        Map<String, Object> map = new HashMap<String, Object>();
        int i  = equipmentMapper.updateEquipmentById(equipment);
        map.put("code", i);
        map.put("msg", "修改成功");
        return map;
    }

    @GetMapping("/deleteEquipmentById")
    public Map<String, Object>deleteEquipmentById (Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        int i  = equipmentMapper.deleteEquipmentById(id);
        map.put("code", i);
        map.put("msg", "删除成功");
        return map;
    }


}