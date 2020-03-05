package com.briup.apps.cms.service.impl;

import com.briup.apps.cms.bean.*;
import com.briup.apps.cms.mapper.ArticleMapper;
import com.briup.apps.cms.mapper.RoleMapper;
import com.briup.apps.cms.service.ArticleService;
import com.briup.apps.cms.service.RoleService;
import com.briup.apps.cms.util.CustomerException;
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
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> findAll() {
        //调用mapper层代码完成查询，并且将查询结果集返回
        RoleExample example = new RoleExample();
        example.createCriteria().andNameIsNotNull();

        return roleMapper.selectByExample(example);
    }

    @Override
    public void deleteById(long id) {
        roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void add(Role role) {
        if(role.getName()!=null){
            roleMapper.insert(role);
        }
    }

    @Override
    public void saveOrUpdate(Role role) throws CustomerException {

        roleMapper.updateByPrimaryKey(role);
    }

}
