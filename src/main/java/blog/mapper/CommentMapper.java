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
    //添加一个评论
    int saveComment(Comment comment);

    //查询父级评论
    List<Comment> findByParentIdNull(@Param("blogId") Long blogId,@Param("parentCommentId") Long parentCommentId);

    //查询一级回复
    List<Comment> findParentIdNotNull(@Param("parentCommentId") Long parentCommentId);

    //查询二级以及所有子集回复
    List<Comment> findByReplayId(@Param("childId") Long childId);
}
