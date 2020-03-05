package com.briup.apps.cms.web.controller;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.User;
import com.briup.apps.cms.service.ArticleService;
import com.briup.apps.cms.service.UserService;
import com.briup.apps.cms.util.Message;
import com.briup.apps.cms.util.MessageUtil;
import com.briup.apps.cms.vm.UserVm;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Atuhor: qin
 * @Create: 2019-12-19-19-57
 * @Time: 19:57
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @ApiOperation("登陆成功会返回token")
    @PostMapping("login")
    //请求方式放到。。。？jession格式？
    public Message login(@RequestBody UserVm userVm){

        //token?

        //企业级登录处理：
        //1.通过用户名密码验证用户身份
        //2.如果用户身份正确，产生一个token令牌 -jwt
        //3.维护token到后来（redius）
        //4.返回token
        Map<String,String> map=new HashMap<>();
        map.put("token","admin-token");
        return MessageUtil.success(map);
    }
    @ApiOperation("通过token获取用户基本信息")
    @GetMapping("info")
    public Message info(String string){
        Map<String,Object> map=new HashMap<>();
        map.put("name","admin");
        map.put("roles",new String[]{"admin"});
        map.put("avatar","http://134.175.154.93:8888/group1/M00/00/1F/rBAACV3ORSiAL_PJAAE66PqFd5A920.png");
        map.put("introduction","超级管理员");
        return MessageUtil.success(map);
    }
    @ApiOperation("退出")
    @PostMapping("logout")
    public Message logout(){
        //1.将token失效

        return MessageUtil.success("success");
    }



    @Autowired
    private UserService userService;

    @ApiOperation(value="查询所有User")
    @GetMapping("findAll")
    public Message findAll(){
        List<User> list = userService.findAll();
        return MessageUtil.success(list);
    }
    @ApiOperation(value = "通过id查询User")
    @GetMapping("deleteById")
    public Message deleteById(long id){
        userService.deleteById(id);
        return MessageUtil.success("删除成功");
    }
    @ApiOperation(value = "添加User")
    @GetMapping("add")
    public Message add(User user){
        userService.add(user);
        return MessageUtil.success("添加成功");
    }
    @ApiOperation(value="保存或更新User")
    //@ApiOperation(value="保存或更新User",notes = "如果id不为空，则为更新，如果id为空，则为保存")
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(User user){
        userService.saveOrUpdate(user);
        return MessageUtil.success("更新成功");
    }
}

