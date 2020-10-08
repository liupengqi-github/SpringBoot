package com.xrd.znsbgl.util;


import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

public class FileUpdate {

//    @RequestMapping(value = "/xxx", produces = "application/json")
    public String Subject(@RequestParam("file") MultipartFile files) {

        // 构建上传目录路径
        // request.getServletContext().getRealPath("/upload");
        String uploadPath = "./temp";//你自己保存的URL;
        // 如果目录不存在就创建
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        // 获取文件的 名称.扩展名
        String oldName = files.getOriginalFilename();
        String extensionName = "";
        // 获取原来的扩展名
        if ((oldName != null) && (oldName.length() > 0)) {
            int dot = oldName.lastIndexOf('.');
            if ((dot > -1) && (dot < (oldName.length() - 1))) {
                extensionName = oldName.substring(dot);
            }
        }
        // 构建文件名称
        String fileName = System.currentTimeMillis() + "_" + System.nanoTime()
                + extensionName;
        // 构建文件路径
        String filePath = uploadPath + File.separator + fileName;
        // 保存文件
        try {
            FileUtils.writeByteArrayToFile(new File(filePath),
                    files.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("接收文件成功 "+filePath);
        return filePath;
    }

}
