package com.briup.apps.cms.web.controller;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.Test;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.service.ArticleService;
import com.briup.apps.cms.service.TestService;
import com.briup.apps.cms.util.ExcelUtils;
import com.briup.apps.cms.util.Message;
import com.briup.apps.cms.util.MessageUtil;
import com.briup.apps.cms.util.PageVM;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Atuhor: qin
 * @Create: 2019-12-19-19-57
 * @Time: 19:57
 * @Description:
 */
@Validated
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @ApiOperation("将文章中的所有数据导出")
    @GetMapping("export")
    public void export(HttpServletResponse response)throws Exception{
        //将文章中的所有数据导出
        PageVM<ArticleExtend> pageVM = articleService.pageQuery(1, 100);
        //调用工具方法将查询出来的数据导出为Excel
        String excelName="articles";
        String[] headList=new String[]{"编号","标题","作者","所属栏目","发布日期"};
        String[] filedList=new String[]{"id","title","authorName","categoryName","publishTime"};
        List<Map<String, Object>> dataList=new ArrayList<>();
        for(ArticleExtend article:pageVM.getList()){
            Map<String, Object> map = new HashMap<>();
            map.put("id",article.getId());
            map.put("title",article.getTitle());
            //map.put("authorName",article.getAuthor()!=null?article.getAuthor().getRealname():"");
            map.put("authorName",article.getAuthorId());
            map.put("categoryName",article.getCategory()!=null?article.getCategory().getName():"");
            map.put("publishTime",article.getPublishTime());
            dataList.add(map);
        }
        ExcelUtils.createExcel(response,excelName,headList,filedList,dataList);
    }


    @ApiOperation(value="通过id查询Article附带其他两张表内容")
    @GetMapping("findById")
    public Message findById(long id){
        ArticleExtend articleExtend = articleService.findById(id);
        return MessageUtil.success(articleExtend);
    }
    @ApiOperation(value="查询所有Article附带其他两张表内容")
    @GetMapping("findAllWithOther")
    public Message findAllWithOther(){
        List<ArticleExtend> list = articleService.findAllWithOther();
        return MessageUtil.success(list);
    }

    @ApiOperation(value="查询所有Article")
    @GetMapping("findAll")
    public Message findAll(){
        List<Article> list = articleService.findAll();
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "通过id删除")
    @DeleteMapping(value="deleteById")
    public Message deleteById(long id){
        articleService.deleteById(id);
        return MessageUtil.success("删除成功");
    }
    @ApiOperation(value="添加Article")
    @GetMapping("add")
    public Message add(Article article){
        articleService.add(article);
        return MessageUtil.success("添加成功");
    }

    @ApiOperation(value = "保存或更新文章信息",notes = "如果id存在为更新，否则为保存")
    @PostMapping(value = "saveOrUpdate")
    public Message saveOrUpdate(Article article
    ){
        articleService.saveOrUpdate(article);

        return MessageUtil.success("更新成功");
    }
    /*@ApiOperation(value="添加Article")
    @GetMapping("add")
    public Message add(Article article){
        articleService.add(article);
        return MessageUtil.success("添加成功");
    }

    @ApiOperation(value = "保存或更新文章信息",notes = "如果id存在为更新，否则为保存")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "编号",paramType = "form"),
            @ApiImplicitParam(name = "title",value = "标题",paramType = "form",required = true),
            @ApiImplicitParam(name = "content",value = "内容",paramType = "form",required = true),
            @ApiImplicitParam(name = "source",value = "内容源码",paramType = "form"),
            @ApiImplicitParam(name = "authorId",value = "作者id",paramType = "form",required = true),
            @ApiImplicitParam(name = "categoryId",value = "栏目id",paramType = "form",required = true)
    })
    @PostMapping(value = "saveOrUpdate")
    public Message saveOrUpdate(
            Long id,
            @NotNull String title,
            @NotNull String content,
            String source,
            @NotNull long authorId,
            @NotNull long categoryId
    ){
        // 将接受到的参数封装到实例对象中
        Article article = new Article();
        article.setId(id);
        article.setTitle(title);
        article.setContent(content);
        article.setSource(source);
        article.setAuthorId(authorId);
        article.setCategoryId(categoryId);
        // 调用service层代码完成保存或者更新操作
        articleService.saveOrUpdate(article);
        return MessageUtil.success("更新成功");
    }*/

    //ids=1&ids=2&...   springmvc
    //ids[]=1&ids=[]=2
    //ids[0]=1&...         struc2
    @ApiOperation(value="批量删除")
    @PostMapping("batchDelete")
    public Message batchDelete(long[] ids){
        articleService.batchDelete(ids);
        return MessageUtil.success("删除成功");
    }

    // 分页查询
    @ApiOperation("分页查询")
    @GetMapping(value = "pageQuery")
    public Message pageQuery(int page,int pageSize){
        PageVM<ArticleExtend> pageVM = articleService.pageQuery(page,pageSize);
        return MessageUtil.success(pageVM);
    }
}

