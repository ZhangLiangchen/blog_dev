package blog.mapper;

import blog.entity.TType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface TypeMapper extends BaseMapper<TType> {

    List<TType> queryBlogById(Long id);

    void deleteById(Long id);
}
