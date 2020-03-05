package com.briup.apps.cms.mapper.extend;

import com.briup.apps.cms.bean.extend.ArticleExtend;

import java.util.List;

/**
 * @Atuhor: qin
 * @Create: 2019-12-20-16-12
 * @Time: 16:12
 * @Description:
 */
public interface ArticleExtendMapper {
    //通过id查询，阅读文章
    ArticleExtend selectById(long id);
    //查询所有
    List<ArticleExtend> selectAllWithOther();

    List<ArticleExtend> pageQuery(int page,int pageSize);

    long count();
}
