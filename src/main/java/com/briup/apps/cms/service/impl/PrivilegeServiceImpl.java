package com.briup.apps.cms.service.impl;

import com.briup.apps.cms.bean.*;
import com.briup.apps.cms.mapper.ArticleMapper;
import com.briup.apps.cms.mapper.PrivilegeMapper;
import com.briup.apps.cms.service.ArticleService;
import com.briup.apps.cms.service.PrivilegeService;
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
public class PrivilegeServiceImpl implements PrivilegeService {

    @Resource
    private PrivilegeMapper privilegeMapper;

    @Override
    public List<Privilege> findAll() {
        //调用mapper层代码完成查询，并且将查询结果集返回
        PrivilegeExample example = new PrivilegeExample();
        example.createCriteria().andNameIsNotNull();

        return privilegeMapper.selectByExample(example);
    }

    @Override
    public void deleteById(long id) {
        privilegeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void add(Privilege privilege) {
        if(privilege.getName()!=null){
            privilegeMapper.insert(privilege);
        }
    }
    @Override
    public void saveOrUpdate(Privilege privilege) throws CustomerException {

        privilegeMapper.updateByPrimaryKey(privilege);
    }

}
