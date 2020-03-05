package com.briup.apps.cms.web.controller;

import com.briup.apps.cms.util.FastDFS;
import com.briup.apps.cms.util.Message;
import com.briup.apps.cms.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: paz
 * @description: 文件控制器类
 * @author: charles
 * @create: 2019-03-15 23:15
 **/
@RestController
@RequestMapping("/file")
public class FileController {


    @ApiOperation(value="远程文件删除")
    @GetMapping("deleteById")
    public Message delete(
            @ApiParam(value = "文件id",required = true) String id
    ) throws Exception {
        int code = FastDFS.delete(id);
        if(code == 0) {
            return MessageUtil.success("删除成功");
        } else {
            return MessageUtil.error("删除失败");
        }
    }


    @ApiOperation(value="文件上传",notes="文件大小限制为3M,文件服务器地址：http://101.132.152.90:8881 。 图片地址为 【服务器地址/groupName/id】,例如 http://101.132.152.90:8881/group1/M00/00/00/rBEg0V4y9eyAafJoAAEiphRevss846_big.jpg")
    @PostMapping("upload")
    public Message upload(
            @RequestParam("file") MultipartFile file, HttpServletRequest req
    ) throws Exception{
        // 1. 获取文件流（文件名称，后缀，大小）
        String fileName = file.getOriginalFilename();
        String ext_name = fileName.substring(fileName.lastIndexOf(".") + 1);
        if(ext_name.contains("?")){
            ext_name = ext_name.substring(0,ext_name.indexOf("?"));
        }
        long fileSize = file.getSize();
/*        if(fileSize > 3145728) {
            return MessageUtil.error("文件大小不能超过了3M");
        }*/
        // 2. 将文件交给fastdfsutil上传到附件服务器（FASTDFS）
        String[] result = FastDFS.upload(file.getBytes(),ext_name);
        if(result!=null && result.length >1) {
            String erpGroupName = result[0];
            String erpFileName = result[1];
            Map<String,String> map = new HashMap<>();
            //map.put("erpFileName",erpFileName);
            map.put("id",erpFileName);
            map.put("groupName",erpGroupName);
            map.put("fileSize",fileSize+"");
            //上传成功
            return MessageUtil.success(map);
        }
        return MessageUtil.error("上传失败");
    }
}
