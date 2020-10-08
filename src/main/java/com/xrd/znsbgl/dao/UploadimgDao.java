package com.xrd.znsbgl.dao;

import com.xrd.znsbgl.entity.Uploadimg;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
/**
 * (Uploadimg)表数据库访问层
 *
 * @author lpq
 * @since 2020-06-24 11:04:35
 */
@Mapper
public interface UploadimgDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Uploadimg queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Uploadimg> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param uploadimg 实例对象
     * @return 对象列表
     */
    List<Uploadimg> queryAll(Uploadimg uploadimg);

    /**
     * 新增数据
     *
     * @param uploadimg 实例对象
     * @return 影响行数
     */
    int insert(Uploadimg uploadimg);

    /**
     * 修改数据
     *
     * @param uploadimg 实例对象
     * @return 影响行数
     */
    int update(Uploadimg uploadimg);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}