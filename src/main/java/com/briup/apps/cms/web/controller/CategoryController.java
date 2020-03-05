package com.briup.apps.cms.web.controller;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.bean.extend.CategoryExtend;
import com.briup.apps.cms.service.ArticleService;
import com.briup.apps.cms.service.CategoryService;
import com.briup.apps.cms.util.Message;
import com.briup.apps.cms.util.MessageUtil;
import com.briup.apps.cms.util.PageVM;
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
@RequestMapping("/category")
public class CategoryController {
    /**
     *
     */
    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value="查询所有Category")
    @GetMapping("findAll")
    //public List<Category> findAll(){
    public Message findAll(){
        //return categoryService.findAll();
        //List<Category> list = categoryService.findAll();
        List<CategoryExtend> list = categoryService.findAll();
        return MessageUtil.success(list);
    }

    @ApiOperation(value="通过id删除Category")
    @GetMapping("deleteById")
    public Message deleteById(long id){
        categoryService.deleteById(id);
        return MessageUtil.success("删除成功");
    }
    @ApiOperation(value="添加Category")
    @GetMapping("add")
    public Message add(Category category){
        categoryService.add(category);
        return MessageUtil.success("添加成功");
    }
    @ApiOperation(value="保存或更新Category")
    //@ApiOperation(value="保存或更新Category",notes = "如果id不为空，则为更新，如果id为空，则为保存")
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Category category){
        categoryService.saveOrUpdate(category);
        return MessageUtil.success("更新成功");
    }

    // 分页查询
    @ApiOperation("分页查询")
    @GetMapping(value = "pageQuery")
    public Message pageQuery(int page,int pageSize){
        PageVM<CategoryExtend> pageVM = categoryService.pageQuery(page,pageSize);
        return MessageUtil.success(pageVM);
    }


}

