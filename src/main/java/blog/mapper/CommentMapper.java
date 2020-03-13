package blog.mapper;

import blog.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
    //根据创建时间倒序来排
    List<Comment> findByBlogIdParentIdNull(@Param("blogId") Long blogId, @Param("blogParentId") Long blogParentId);
    //查询父级对象
    Comment findByParentCommentId(Long parentCommentId);
    //添加一个评论
    int saveComment(Comment comment);
}
