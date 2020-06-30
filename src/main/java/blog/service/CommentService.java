package blog.service;

import blog.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface CommentService extends IService<Comment> {
    //查询评论列表
    List<Comment> listComment(Long blogId);

    //保存评论
    int saveComment(Comment comment);

}
