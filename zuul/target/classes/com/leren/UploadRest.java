package com.leren;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.log4j.Logger;
import org.apache.shiro.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author lee
 * @Date:12/03/2018
 */

@RestController
public class UploadRest {


    private Logger logger = Logger.getLogger(UploadRest.class);


    @PostMapping(value = "upload")
    @HystrixCommand(fallbackMethod = "uploadFallback")
    public String upload(@RequestParam MultipartFile photo) {

        Assert.notNull(photo, "上传文件不存在");

        logger.info("[upload File]:文件名称:" + photo.getOriginalFilename() + ",文件大小:" + photo.getSize());


        return "file-" + System.currentTimeMillis() + ".jpg";
    }


    public String uploadFallback(@RequestParam MultipartFile photo) {

        return "no file";
    }
}
