package blog.entity;

import java.io.Serializable;

/**
 * (TBlogTags)实体类
 *
 * @author makejava
 * @since 2020-02-29 20:41:30
 */
public class TBlogTags implements Serializable {
    private static final long serialVersionUID = 588070997790796294L;

    private Integer id;

    private Long tagId;

    private String blogId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

}