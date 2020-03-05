package com.briup.apps.cms.service;


import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.CategoryExample;
import com.briup.apps.cms.bean.extend.CategoryExtend;
import com.briup.apps.cms.util.CustomerException;
import com.briup.apps.cms.util.PageVM;

import java.util.List;

/**
 * @Atuhor: qin
 * @Create: 2019-12-19-19-10
 * @Time: 19:10
 * @Description:
 */
public interface CategoryService {
    //查找
   // List<Category> findAll();
    //
    List<CategoryExtend> findAll();

    void deleteById(long id);

    void add(Category category);

    void saveOrUpdate(Category category) throws CustomerException;
    //分页查询{count,list}
    PageVM<CategoryExtend> pageQuery(int page, int pageSize);

}
