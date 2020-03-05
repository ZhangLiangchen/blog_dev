package blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TBlog {


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

    private TType type;

    private TUser TUser;

    private List<TTag> TTags = new ArrayList<>();

    private List<TComment> TComments = new ArrayList<>();



    @Override
    public String toString() {
        return "TBlog{" +
                "typeId=" + typeId +','+ "title='" + title+
                '}';
    }
}
