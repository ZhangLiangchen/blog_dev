package blog.mapper;

import blog.entity.Type;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TypeMapper extends BaseMapper<Type> {

    List<Type> queryBlogById(Long id);

    void deleteById(Long id);
}
