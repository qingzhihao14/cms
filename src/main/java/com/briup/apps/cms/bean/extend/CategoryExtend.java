package com.briup.apps.cms.bean.extend;

import com.briup.apps.cms.bean.Category;

/**
 * @Atuhor: qin
 * @Create: 2019-12-20-14-33
 * @Time: 14:33
 * @Description:栏目拓展类（多表查询：查询子栏目，把父栏目内容也查询出来）
 */
public class CategoryExtend extends Category {
    private Category parent;

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }
}
