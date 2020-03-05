package com.briup.apps.cms.web.controller;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.Role;
import com.briup.apps.cms.service.ArticleService;
import com.briup.apps.cms.service.RoleService;
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
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation("查询所有Role")
    @GetMapping("findAll")
    public Message findAll(){
        List<Role> list = roleService.findAll();
        return MessageUtil.success(list);
    }
    @ApiOperation(value="通过id删除Role")
    @GetMapping("deleteById")
    public Message deleteById(long id){
        roleService.deleteById(id);
        return MessageUtil.success("删除成功");
    }
    @ApiOperation(value="添加Role")
    @GetMapping("add")
    public Message add(Role role){
        roleService.add(role);
        return MessageUtil.success("添加成功");
    }

    @ApiOperation(value="保存或更新Role")
    //@ApiOperation(value="保存或更新Role",notes = "如果id不为空，则为更新，如果id为空，则为保存")
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Role role){
        roleService.saveOrUpdate(role);
        return MessageUtil.success("更新成功");
    }
}

