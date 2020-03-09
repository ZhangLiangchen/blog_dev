package blog.service.impl;

import blog.entity.Comment;
import blog.mapper.BlogMapper;
import blog.mapper.CommentMapper;
import blog.service.CommentService;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    private CommentMapper commentMapper;
    private BlogMapper blogMapper;

//    @Override
//    public List<Comment> listCommentByBlogId(Long blogId) {
//        //没有父节点的默认为-1
//        List<Comment> comments = commentMapper.findByBlogIdParentIdNull(blogId, Long.parseLong("-1"));
//        return eachComment(comments);
//    }
}
