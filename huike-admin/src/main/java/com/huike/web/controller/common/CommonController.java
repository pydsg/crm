package com.huike.web.controller.common;

import com.huike.common.core.controller.BaseController;
import com.huike.common.core.domain.AjaxResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 通用请求处理
 */
@RestController
public class CommonController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(CommonController.class);


    /**
     * 通用上传请求
     */
    @PostMapping("/common/upload")
    public AjaxResult uploadFile(MultipartFile file){
        try{
            // 上传文件路径
            return null;
        }catch (Exception e){
            return AjaxResult.error(e.getMessage());
        }
    }
}