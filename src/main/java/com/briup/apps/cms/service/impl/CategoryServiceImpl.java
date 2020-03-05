package com.briup.apps.cms.service.impl;


import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.CategoryExample;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.bean.extend.CategoryExtend;
import com.briup.apps.cms.mapper.CategoryMapper;
import com.briup.apps.cms.mapper.extend.CategoryExtendMapper;
import com.briup.apps.cms.service.CategoryService;
import com.briup.apps.cms.util.CustomerException;
import com.briup.apps.cms.util.PageVM;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Atuhor: qin
 * @Create: 2019-12-19-11-48
 * @Time: 11:48
 * @Description:
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private CategoryExtendMapper categoryExtendMapper;
    @Override
    public List<CategoryExtend> findAll() {
        //调用mapper层代码完成查询，并且将查询结果集返回
        //CategoryExample example = new CategoryExample();
        //example.createCriteria().andDescriptionIsNotNull();
        //CategoryExample example = new CategoryExample();
        return categoryExtendMapper.selectAllWithParent();
    }

    @Override
    public void deleteById(long id) {
        categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void add(Category category) {
        if(category.getName()!=null){
            categoryMapper.insert(category);
        }
    }

    @Override
    public void saveOrUpdate(Category category) throws CustomerException {
        if(category.getId() != null){
            category.setCreateTime(new Date().getTime());
            categoryMapper.updateByPrimaryKey(category);
        } else {
            // 同一个作者不允许发布同标题的文章
            CategoryExample example = new CategoryExample();
            example.createCriteria()
                    .andNameEqualTo(category.getName())
                    .andDescriptionEqualTo(category.getDescription());
            List<Category> list = categoryMapper.selectByExample(example);
            if(list.size() >0 ){
                throw new CustomerException("您已经发布过同标题文章");
            }
            //保存
            //1. 初始化
            category.setCreateTime(new Date().getTime());
            category.setNo(1);
            //2. 插入
            categoryMapper.insert(category);
        }
        //categoryMapper.updateByPrimaryKey(category);
    }

    //分页
    @Override
    public PageVM<CategoryExtend> pageQuery(int page, int pageSize) {
        //1. 查数据
        List<CategoryExtend> list = categoryExtendMapper.pageQuery(page,pageSize);
        //2. 查数量
        long total = categoryExtendMapper.count();
        //3. 封装数据模型
        PageVM<CategoryExtend> pageVM = new PageVM<>();
        pageVM.setList(list);
        pageVM.setTotal(total);
        pageVM.setPage(page);
        pageVM.setPageSize(pageSize);
        return pageVM;
    }
}
