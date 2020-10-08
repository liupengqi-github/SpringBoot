package com.xrd.znsbgl.controller;

import com.xrd.znsbgl.entity.Uploadimg;
import com.xrd.znsbgl.service.UploadimgService;
import com.xrd.znsbgl.util.Base64Test;
import com.xrd.znsbgl.util.FileUpdate;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.*;
import com.xrd.znsbgl.util.DataUtil;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;

/**
 * (Uploadimg)表控制层
 *
 * @author lpq
 * @since 2020-06-24 11:04:37
 */
//如果没有放在项目里 需要加上跨域注解
@CrossOrigin
@RestController
@RequestMapping("uploadimg")
@ResponseBody
public class UploadimgController {
    /**
     * 服务对象
     */
    @Resource
    private UploadimgService uploadimgService;


     /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return DataUtil对象
     */
    @GetMapping("selectUploadimgById")
    public DataUtil selectUploadimgById(Integer id) {
        DataUtil dataUtil = new DataUtil();
        dataUtil.setCode(1);
        dataUtil.setMsg("查询成功");
        //dataUtil.setData(uploadimgService.queryById(id));
        Uploadimg uploadimg = (uploadimgService.queryById(id));
        //处理图片
        Base64Test base64Test = new Base64Test();
        String img = base64Test.GetImageStr3(uploadimg.getImgurl());
        uploadimg.setImgbase(img);
        dataUtil.setData(uploadimg);

        return dataUtil;
    }
    /**
     * 分页查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return DataUtil对象
     */
    @GetMapping("selectUploadimgByLimit")
    public DataUtil selectUploadimgByLimit(int offset, int limit){
        DataUtil dataUtil = new DataUtil();
        dataUtil.setCode(1);
        dataUtil.setMsg("查询成功");
        dataUtil.setData(uploadimgService.queryAllByLimit(offset, limit));
        return dataUtil;
    }
    /**
     * 通过实体作为筛选条件查询
     * @param uploadimg 实例对象
     * @return DataUtil对象
     */
    @GetMapping("selectUploadimg")
    public DataUtil selectUploadimg(Uploadimg uploadimg){
        DataUtil dataUtil = new DataUtil();
        dataUtil.setCode(1);
        dataUtil.setMsg("查询成功");
        dataUtil.setData(uploadimgService.queryAll(uploadimg));
        return dataUtil;
    }

    /**
     * 新增数据
     *
     * @param uploadimg 实例对象
     * @return DataUtil对象
     */
    @PostMapping("insertUploadimg")
    public DataUtil insert(Uploadimg uploadimg){
        DataUtil dataUtil = new DataUtil();
        dataUtil.setCode(1);
        dataUtil.setMsg("插入成功");
        dataUtil.setData(uploadimgService.insert(uploadimg));
        return dataUtil;
    }

    /**
     * 修改数据
     *
     * @param uploadimg 实例对象
     * @return DataUtil对象
     */
    @GetMapping("updateUploadimg")
    public DataUtil updateAdmin(Uploadimg uploadimg){
        DataUtil dataUtil = new DataUtil();
        dataUtil.setCode(1);
        dataUtil.setMsg("插入成功");
        dataUtil.setData(uploadimgService.update(uploadimg));
        return dataUtil;
    }
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return DataUtil对象
     */
    @GetMapping("deleteUploadimgById")
    public DataUtil deleteUploadimgById(Integer id){
        DataUtil dataUtil = new DataUtil();
        dataUtil.setCode(1);
        dataUtil.setMsg("删除成功");
        dataUtil.setData(uploadimgService.deleteById(id));
        return dataUtil;
    }
    @RequestMapping(value = "/uploadimgFile")
    public DataUtil uploadimgFile(@RequestParam("file")MultipartFile files){
        System.out.println(files);
        DataUtil dataUtil = new DataUtil();
        FileUpdate fileUpdate = new FileUpdate();
        String url = fileUpdate.Subject(files);
        Uploadimg uploadimg = new Uploadimg();
        uploadimg.setImgurl(url);
        dataUtil.setData(uploadimgService.insert(uploadimg));
        dataUtil.setCode(1);
        dataUtil.setMsg("插入成功");
        return dataUtil;
    }
}