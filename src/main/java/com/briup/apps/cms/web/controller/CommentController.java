package com.briup.apps.cms.web.controller;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.Comment;
import com.briup.apps.cms.bean.extend.CategoryExtend;
import com.briup.apps.cms.bean.extend.CommentExtend;
import com.briup.apps.cms.service.ArticleService;
import com.briup.apps.cms.service.CommentService;
import com.briup.apps.cms.util.Message;
import com.briup.apps.cms.util.MessageUtil;
import com.briup.apps.cms.util.PageVM;
import com.sun.org.apache.bcel.internal.generic.MULTIANEWARRAY;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @Atuhor: qin
 * @Create: 2019-12-19-19-57
 * @Time: 19:57
 * @Description:
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ApiOperation(value="查询所有Comment")
    @GetMapping("findAll")
    public Message findAll(){
        List<Comment> list = commentService.findAll();
        return MessageUtil.success(list);
    }

    @ApiOperation(value="通过id删除Comment")
    @GetMapping("deleteById")
    public Message deleteById(long id){
        commentService.deleteById(id);
        return MessageUtil.success("删除成功");
    }
    @ApiOperation(value="添加Comment")
    @GetMapping("add")
    public Message add(Comment comment){
        commentService.add(comment);
        return MessageUtil.success("添加成功");
    }
    @ApiOperation(value="保存或更新Comment")
    //@ApiOperation(value="保存或更新Comment",notes = "如果id不为空，则为更新，如果id为空，则为保存")
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Comment comment){
        commentService.saveOrUpdate(comment);
        return MessageUtil.success("更新成功");
    }

    // 分页查询
    @ApiOperation("分页查询")
    @GetMapping(value = "pageQuery")
    public Message pageQuery(int page,int pageSize){
        PageVM<CommentExtend> pageVM = commentService.pageQuery(page,pageSize);
        return MessageUtil.success(pageVM);
    }
}

