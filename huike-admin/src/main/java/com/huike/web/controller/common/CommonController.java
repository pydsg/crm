package com.huike.web.controller.common;

import com.huike.common.core.controller.BaseController;
import com.huike.common.core.domain.AjaxResult;
import com.huike.web.controller.common.minIO.config.MinioConfig;
import com.huike.web.controller.common.minIO.controller.FileController;
import com.huike.web.controller.common.minIO.pojo.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 通用请求处理
 */
@RestController
public class CommonController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(CommonController.class);

    @Autowired
    private FileController fileController;
    @Autowired
    private MinioConfig minioConfig;

    /**
     * 通用上传请求
     */
    @PostMapping("/common/upload")
    public AjaxResult uploadFile(MultipartFile file){
        try{
            // 上传文件路径
            String nowDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
            ResultBean upload = fileController.upload(new MultipartFile[]{file}, nowDate);
            if("上传失败".equals(upload.getMsg())) {
                return AjaxResult.error("上传失败");
            }
            Map<String, Object> data = (Map) upload.getData();
            String bucketName = (String) data.get("bucketName");
            List fileNameList = (List) data.get("fileName");
            String url = minioConfig.getMinioProperties().getEndpoint() +"/"+ bucketName + "/" + nowDate + "/" + fileNameList.get(0);
            String fileName = "/"+ bucketName + "/" + nowDate + "/" + fileNameList.get(0);
            AjaxResult success = AjaxResult.success();
            success.put("fileName", fileName);
            success.put("url", url);
            return success;
        }catch (Exception e){
            return AjaxResult.error(e.getMessage());
        }
    }

}