package com.briup.apps.cms.service.impl;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.ArticleExample;
import com.briup.apps.cms.bean.Test;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.mapper.TestMapper;
import com.briup.apps.cms.mapper.ArticleMapper;
import com.briup.apps.cms.mapper.extend.ArticleExtendMapper;
import com.briup.apps.cms.service.ArticleService;
import com.briup.apps.cms.service.TestService;
import com.briup.apps.cms.util.CustomerException;
import com.briup.apps.cms.util.PageVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

/**
 * @Atuhor: qin
 * @Create: 2019-12-19-11-48
 * @Time: 11:48
 * @Description:
 */
@Service
public class ArticleServiceImpl implements ArticleService{


    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private ArticleExtendMapper articleExtendMapper;
    @Override
    public ArticleExtend findById(long id) {
        return articleExtendMapper.selectById(id);
    }

    @Override
    public List<ArticleExtend> findAllWithOther() {
        return articleExtendMapper.selectAllWithOther();
    }
    
    @Override
    public List<Article> findAll() {
        //调用mapper层代码完成查询，并且将查询结果集返回
        ArticleExample example = new ArticleExample();
        example.createCriteria().andTitleIsNotNull();
        return articleMapper.selectByExample(example);
    }

    @Override
    public void deleteById(long id) throws CustomerException {
        Article article=articleMapper.selectByPrimaryKey(id);
        if(article==null){
            throw new CustomerException("该文章不存在");
        }
        articleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void add(Article article) {
        if(article.getTitle()!=null){
            articleMapper.insert(article);
        }
    }

    @Override
    public void saveOrUpdate(Article article) throws CustomerException {
        //articleMapper.insert(article);
        if(article.getId() != null){
            //保存修改文章
            article.setPublishTime(new Date().getTime());
            articleMapper.updateByPrimaryKey(article);
        } else {
            //增加更新文章
            // 同一个作者不允许发布同标题的文章
            ArticleExample example = new ArticleExample();
            example
                    .createCriteria()
                    .andAuthorIdEqualTo(article.getAuthorId())
                    .andTitleEqualTo(article.getTitle());
            List<Article> list =
                    articleMapper.selectByExample(example);
            if(list.size() >0 ){
                throw new CustomerException("您已经发布过同标题文章");
            }
            //保存
            //1. 初始化
            article.setReadTimes(0l);
            article.setPublishTime(new Date().getTime());
            article.setThumpDown(0l);
            article.setThumpUp(0l);
            article.setStatus(ArticleExtend.STATUS_UNCHECK);
            //2. 插入
            articleMapper.insert(article);
        }
    }

    @Override
    public void batchDelete(long[] ids) throws CustomerException {
        for(long id : ids){
            this.deleteById(id);
        }
    }

    @Override
    public PageVM<ArticleExtend> pageQuery(int page, int pageSize) {
        //1. 查数据
        List<ArticleExtend> list = articleExtendMapper.pageQuery(page,pageSize);
        //2. 查数量
        long total = articleExtendMapper.count();
        //3. 封装数据模型
        PageVM<ArticleExtend> pageVM = new PageVM<>();
        pageVM.setList(list);
        pageVM.setTotal(total);
        pageVM.setPage(page);
        pageVM.setPageSize(pageSize);
        return pageVM;
    }
}