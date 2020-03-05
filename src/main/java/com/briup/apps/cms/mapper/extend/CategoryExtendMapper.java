package com.briup.apps.cms.mapper.extend;

import com.briup.apps.cms.bean.extend.CategoryExtend;

import java.util.List;

/**
 * @Atuhor: qin
 * @Create: 2019-12-20-14-35
 * @Time: 14:35
 * @Description:栏目拓展类的映射接口
 */
public interface CategoryExtendMapper {
    //查询所有，并级联parent
    //@Select("select * from cms_category")不好映射出去
    //所以写xml
    List <CategoryExtend> selectAllWithParent();
    List<CategoryExtend> pageQuery(int page,int pageSize);
    long count();
}
