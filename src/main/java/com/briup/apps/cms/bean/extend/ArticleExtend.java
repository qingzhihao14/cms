package com.briup.apps.cms.bean.extend;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.User;

/**
 * @Atuhor: qin
 * @Create: 2019-12-20-16-11
 * @Time: 16:11
 * @Description:
 */
public class ArticleExtend extends Article {

    //静态常量
    public static final String STATUS_UNCHECK="待审核";
    public static final String STATUS_CHECK_PASS="审核通过";
    public static final String STATUS_CHECK_NOPASS="审核未通过";

    //关联authorId，categoryId的内容
    private Category category;
    private User author;



    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
