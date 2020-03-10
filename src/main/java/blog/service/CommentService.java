package blog.service;

import blog.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface CommentService extends IService<Comment> {
    List<Comment> listCommentByBlogId(Long blogId);

    int saveComment(Comment comment);
}
