package com.briup.apps.cms.web.controller;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.Privilege;
import com.briup.apps.cms.service.ArticleService;
import com.briup.apps.cms.service.PrivilegeService;
import com.briup.apps.cms.util.Message;
import com.briup.apps.cms.util.MessageUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Atuhor: qin
 * @Create: 2019-12-19-19-57
 * @Time: 19:57
 * @Description:
 */
@RestController
@RequestMapping("/privilege")
public class PrivilegeController {

    @Autowired
    private PrivilegeService privilegeService;

    @ApiOperation(value="查询所有Privilege")
    @GetMapping("findAll")
    public Message findAll(){
        List<Privilege> list = privilegeService.findAll();
        return MessageUtil.success(list);
    }
    @ApiOperation(value="通过id删除Privilege")
    @GetMapping("deleteById")
    public Message deleteById(long id){
        privilegeService.deleteById(id);
        return MessageUtil.success("删除成功");
    }
    @ApiOperation(value="添加Privilege")
    @GetMapping("add")
    public Message add(Privilege privilege){
        privilegeService.add(privilege);
        return MessageUtil.success("添加成功");
    }
    @ApiOperation(value="保存或更新Privilege")
    //@ApiOperation(value="保存或更新Privilege",notes = "如果id不为空，则为更新，如果id为空，则为保存")
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Privilege privilege){
        privilegeService.saveOrUpdate(privilege);
        return MessageUtil.success("更新成功");
    }

}

