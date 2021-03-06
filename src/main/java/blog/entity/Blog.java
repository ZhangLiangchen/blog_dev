package blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@TableName("t_blog")
public class Blog {


    @TableId(type = IdType.AUTO)
    private Long id;
    private String title;
    private String content;
    private String firstPicture;
    private String flag;
    private Integer views;
    private boolean appreciation;
    private boolean shareStatement;
    private boolean commentabled;
    private boolean published;
    private boolean recommend;
    private Date createTime;
    private Date updateTime;
    //这个属性用来在mybatis中进行连接查询的
    private Long typeId;
    private Long userId;
    //获取多个标签的id
    private String tagIds;
    private String description;

    @TableField(exist = false)
    private Type type;

    @TableField(exist = false)
    private User User;

    @TableField(exist = false)
    private List<Tag> Tags = new ArrayList<>();

    @TableField(exist = false)
    private List<Comment> Comments = new ArrayList<>();



    @Override
    public String toString() {
        return "TBlog{" +
                "typeId=" + typeId +','+ "title='" + title+
                '}';
    }
}
