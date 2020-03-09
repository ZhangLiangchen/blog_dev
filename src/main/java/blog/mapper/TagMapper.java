package blog.mapper;

import blog.entity.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface TagMapper extends BaseMapper<Tag> {

    int saveTag(Tag tag);

    int deleteTag(Long id);

    int updateTag(Tag tag);

    Tag getById(Long id);

    Tag getByName(String name);


}
