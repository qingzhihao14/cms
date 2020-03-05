package com.briup.apps.cms.bean.extend;


import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.Comment;
import com.briup.apps.cms.bean.User;

/**
 * @Atuhor: qin
 * @Create: 2019-12-20-16-11
 * @Time: 16:11
 * @Description:
 */
public class CommentExtend extends Comment {

    //静态常量
    public static final String STATUS_UNCHECK="待审核";
    public static final String STATUS_CHECK_PASS="审核通过";
    public static final String STATUS_CHECK_NOPASS="审核未通过";

    //关联authorId，articleId的内容
    private User author;
    private Article article;

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
