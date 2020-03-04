package blog.service.impl;

import blog.entity.Comment;
import blog.mapper.CommentMapper;
import blog.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service("CommentServiceImpl")
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
}
