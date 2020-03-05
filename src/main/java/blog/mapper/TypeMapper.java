package blog.mapper;

import blog.entity.Type;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface TypeMapper extends BaseMapper<Type> {

    List<Type> queryBlogById(Long id);

    void deleteById(Long id);
}
