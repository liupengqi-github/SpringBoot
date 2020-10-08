package com.xrd.znsbgl.service;

import com.xrd.znsbgl.entity.Uploadimg;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * (Uploadimg)表服务接口
 *
 * @author lpq
 * @since 2020-06-24 11:04:37
 */
public interface UploadimgService {
    @Autowired
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Uploadimg queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Uploadimg> queryAllByLimit(int offset, int limit);
    
    /**
     * 通过实体作为筛选条件查询
     * @param uploadimg 实体
     * @return 对象列表
     */
    List<Uploadimg> queryAll(Uploadimg uploadimg);
    /**
     * 新增数据
     *
     * @param uploadimg 实例对象
     * @return 实例对象
     */
    Uploadimg insert(Uploadimg uploadimg);

    /**
     * 修改数据
     *
     * @param uploadimg 实例对象
     * @return 实例对象
     */
    Uploadimg update(Uploadimg uploadimg);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}