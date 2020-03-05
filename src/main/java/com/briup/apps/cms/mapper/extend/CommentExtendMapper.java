package com.briup.apps.cms.mapper.extend;


import com.briup.apps.cms.bean.extend.CommentExtend;
import java.util.List;

/**
 * @Atuhor: qin
 * @Create: 2019-12-20-14-35
 * @Time: 14:35
 * @Description:栏目拓展类的映射接口
 */
public interface CommentExtendMapper {
    //需要修改CommentExtend替换Comment
    List<CommentExtend> pageQuery(int page, int pageSize);
    long count();
}
