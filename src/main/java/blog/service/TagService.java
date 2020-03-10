package blog.service;

import blog.entity.Tag;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface TagService extends IService<Tag> {

    int saveTag(Tag tag);

    int deleteTag(Long id);

    int updateTag(Tag tag);

    Tag getById(Long id);

    Tag getByName(String name);

    List<Tag> getTagByString(String text);

    List<Tag> getAllTag();


}
