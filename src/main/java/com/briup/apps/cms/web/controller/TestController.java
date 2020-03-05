package com.briup.apps.cms.web.controller;

import com.briup.apps.cms.bean.Test;
import com.briup.apps.cms.service.TestService;
import com.briup.apps.cms.util.Message;
import com.briup.apps.cms.util.MessageUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Atuhor: qin
 * @Create: 2019-12-19-11-52
 * @Time: 11:52
 * @Description:
 * http://127.0.0.1:7777/test/findAll
 */
//参数校验，数据拦截
@Validated
//对接前端
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

/*    @GetMapping("findAll")
    public List<Test> findAll(){
        return testService.findAll();
    }*/
/*    @GetMapping("findAll")
    public Message findAll(){
        List<Test> list = testService.findAll();
        return new Message(status200);
    }*/
    @ApiOperation(value="查询所有Test")
    @GetMapping("findAll")
    public Message findAll(){
        List<Test> list = testService.findAll();
        return MessageUtil.success(list);
    }
    @ApiOperation(value="通过id删除Test")
    @DeleteMapping("deleteById")
    public Message deleteById(long id){
        testService.deleteById(id);
        return MessageUtil.success("删除成功");
    }
    //提示信息，notes附加描述
    @ApiOperation(value="保存或更新Test",notes = "如果id不为空，则为更新，如果id为空，则为保存")
    //对于参数类型的描述(只是为Swagger提供验证,校验信息)
    @ApiImplicitParams({
            @ApiImplicitParam(name="id" ,value="主键", paramType = "form"),
            @ApiImplicitParam(name="name" ,value="名称", paramType = "form",required = true),
            @ApiImplicitParam(name="age" ,value="年龄", paramType = "form",required = true)
    })
    @PostMapping("saveOrUpdate")
    //参数前加@NotNull才是真正的参数校验
    //public Message saveOrUpdate(Test test){
    public Message saveOrUpdate(
            Long id,
            @NotNull String name,
            @NotNull Integer age){
        Test test = new Test();
        test.setId(id);
        test.setName(name);
        test.setAge(age);
        testService.saveOrUpdate(test);
        return MessageUtil.success("更新成功");
    }
}
