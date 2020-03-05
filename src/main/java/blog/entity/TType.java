package blog.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TType {
    private Long id;
    private String name;

    public int getBlogsNum() {
        return blogsNum;
    }

    public void setBlogsNum(int blogsNum) {
        this.blogsNum = blogsNum;
    }

    @TableField(exist = false)
    private int blogsNum;

    @TableField(exist = false)
    private List<TBlog> blogs = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TBlog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<TBlog> blogs) {
        this.blogs = blogs;
    }
}
