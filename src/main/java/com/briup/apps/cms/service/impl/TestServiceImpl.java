package com.briup.apps.cms.service.impl;

import com.briup.apps.cms.bean.Test;
import com.briup.apps.cms.mapper.TestMapper;
import com.briup.apps.cms.service.TestService;
import com.briup.apps.cms.util.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TestServiceImpl implements TestService {
    //@Auto有时候注入不进来
    @Resource
    private TestMapper testMapper;

    @Override
    public List<Test> findAll() {
        //调用mapper层代码完成查询，并且将查询结果集返回
        return testMapper.selectAll();
    }

    @Override
    public void deleteById(Long id) {
        testMapper.deleteById(id);
    }

    @Override
    public void saveOrUpdate(Test test) throws CustomerException {
        if(test.getId()==null){
            //保存,name不能相同
            Test t = testMapper.selectByName(test.getName());
            if(t!=null){
                //名字被占用
                throw new CustomerException("名字已经被占用");
            }
            testMapper.insert(test);
        }else {
            //更新
            testMapper.update(test);
        }
    }
}
