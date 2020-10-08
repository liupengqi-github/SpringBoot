package com.xrd.znsbgl.service.impl;

import com.xrd.znsbgl.entity.Uploadimg;
import com.xrd.znsbgl.dao.UploadimgDao;
import com.xrd.znsbgl.service.UploadimgService;
import org.springframework.stereotype.Service;
import com.xrd.znsbgl.util.MD5Util;
import javax.annotation.Resource;
import java.util.List;

/**
 * (Uploadimg)表服务实现类
 *
 * @author lpq
 * @since 2020-06-24 11:04:37
 */
@Service("uploadimgService")
public class UploadimgServiceImpl implements UploadimgService {
    @Resource
    private UploadimgDao uploadimgDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Uploadimg queryById(Integer id) {
        return this.uploadimgDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Uploadimg> queryAllByLimit(int offset, int limit) {
        return this.uploadimgDao.queryAllByLimit(offset, limit);
    }
    /**
     * 通过实体作为筛选条件查询
     * @param uploadimg 实体
     * @return 对象列表
     */
    @Override
    public List<Uploadimg> queryAll(Uploadimg uploadimg) {
        return this.uploadimgDao.queryAll(uploadimg);
    }

    /**
     * 新增数据
     *
     * @param uploadimg 实例对象
     * @return 实例对象
     */
    @Override
    public Uploadimg insert(Uploadimg uploadimg) {
                
        this.uploadimgDao.insert(uploadimg);
        return uploadimg;
    }

    /**
     * 修改数据
     *
     * @param uploadimg 实例对象
     * @return 实例对象
     */
    @Override
    public Uploadimg update(Uploadimg uploadimg) {
        this.uploadimgDao.update(uploadimg);
        return this.queryById(uploadimg.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.uploadimgDao.deleteById(id) > 0;
    }
}