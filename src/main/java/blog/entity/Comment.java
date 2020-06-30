package blog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import blog.dto.DetailedBlog;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@TableName("t_comment")
public class Comment {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String nickname;
    private String email;
    private String content;
    private String avatar;
    private Date createTime;
    private Long blogId;
    private Long parentCommentId;

    //回复评论
    @TableField(exist = false)
    private List<Comment> replyComments = new ArrayList<>();
    @TableField(exist = false)
    private Comment parentComment;
    @TableField(exist = false)
    private String parentNickname;
    @TableField(exist = false)
    private DetailedBlog blog;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                ", avatar='" + avatar + '\'' +
                ", createTime=" + createTime +
                ", parentCommentId=" + parentCommentId +
                ", replyComments=" + replyComments +
                ", parentComment=" + parentComment +
                ", parentNickname='" + parentNickname + '\'' +
                ", blog=" + blog +
                '}';
    }
}
