package com.briup.apps.cms.service.impl;


import com.briup.apps.cms.bean.Comment;
import com.briup.apps.cms.bean.CommentExample;
import com.briup.apps.cms.bean.extend.CommentExtend;
import com.briup.apps.cms.mapper.CommentMapper;
import com.briup.apps.cms.mapper.extend.CommentExtendMapper;
import com.briup.apps.cms.service.CommentService;
import com.briup.apps.cms.util.CustomerException;
import com.briup.apps.cms.util.PageVM;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @Atuhor: qin
 * @Create: 2019-12-19-11-48
 * @Time: 11:48
 * @Description:
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Resource
    private CommentExtendMapper commentExtendMapper;
    @Override
    public List<Comment> findAll() {
        //调用mapper层代码完成查询，并且将查询结果集返回
        CommentExample example = new CommentExample();
        example.createCriteria().andContentIsNotNull();
        return commentMapper.selectByExample(example);
    }

    @Override
    public void deleteById(long id) {
        commentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void add(Comment comment) {
        if(comment.getContent()!=null){
            commentMapper.insert(comment);
        }
    }

    @Override
    public void saveOrUpdate(Comment comment) throws CustomerException {

        commentMapper.updateByPrimaryKey(comment);
    }

    //分页
    @Override
    public PageVM<CommentExtend> pageQuery(int page, int pageSize) {
        //1. 查数据
        List<CommentExtend> list = commentExtendMapper.pageQuery(page,pageSize);
        //2. 查数量
        long total = commentExtendMapper.count();
        //3. 封装数据模型
        PageVM<CommentExtend> pageVM = new PageVM<>();
        pageVM.setList(list);
        pageVM.setTotal(total);
        pageVM.setPage(page);
        pageVM.setPageSize(pageSize);
        return pageVM;
    }

}
