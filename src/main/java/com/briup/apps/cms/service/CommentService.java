package com.briup.apps.cms.service;



import com.briup.apps.cms.bean.Comment;
import com.briup.apps.cms.bean.extend.CommentExtend;
import com.briup.apps.cms.util.CustomerException;
import com.briup.apps.cms.util.PageVM;

import java.util.List;

/**
 * @Atuhor: qin
 * @Create: 2019-12-19-19-10
 * @Time: 19:10
 * @Description:
 */
public interface CommentService {
    //查找
    List<Comment> findAll();

    void deleteById(long id);

    void add(Comment comment);

    void saveOrUpdate(Comment comment) throws CustomerException;

    //分页查询{count,list}
    //需要修改CommentExtend替换Comment
    PageVM<CommentExtend> pageQuery(int page, int pageSize);

}
