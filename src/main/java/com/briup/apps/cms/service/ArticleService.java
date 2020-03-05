package com.briup.apps.cms.service;


import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.Test;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.util.CustomerException;
import com.briup.apps.cms.util.PageVM;

import java.util.List;

/**
 * @Atuhor: qin
 * @Create: 2019-12-19-19-10
 * @Time: 19:10
 * @Description:
 */
public interface ArticleService {
    //查找(关联authorId，categoryId的内容)
    ArticleExtend findById(long id);
    List<ArticleExtend> findAllWithOther();

    List<Article> findAll();

    void deleteById(long id)throws CustomerException;

    void add(Article article);

    //凡是保存或更新都要抛出异常
    void saveOrUpdate(Article article) throws CustomerException ;

    //批量删除
    void batchDelete(long[] ids) throws CustomerException;

    //分页查询{count,list}
    PageVM<ArticleExtend> pageQuery(int page,int pageSize);

}
