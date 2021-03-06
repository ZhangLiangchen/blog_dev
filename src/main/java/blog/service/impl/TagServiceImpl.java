package blog.service.impl;

import blog.entity.Tag;
import blog.mapper.TagMapper;
import blog.service.TagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public int saveTag(Tag tag) {
        return tagMapper.saveTag(tag);
    }

    @Override
    public int deleteTag(Long id) {
        return tagMapper.deleteTag(id);
    }

    @Override
    public int updateTag(Tag tag) {
        return tagMapper.updateTag(tag);
    }

    @Override
    public Tag getById(Long id) {
        return tagMapper.getById(id);
    }

    @Override
    public Tag getByName(String name) {
        return tagMapper.getByName(name);
    }

    @Override
    public List<Tag> getTagByString(String text) {
        List<Tag> tags = new ArrayList<>();
        List<Long> longs = convertToList(text);
        for (Long aLong : longs) {
            tags.add(tagMapper.getById(aLong));
        }
        return tags;

    }


    private List<Long> convertToList(String ids) {
        List<Long> list = new ArrayList<>();
        if (!"".equals(ids) && ids != null) {
            String[] idarray = ids.split(",");
            for (int i=0; i < idarray.length;i++) {
                list.add(new Long(idarray[i]));
            }
        }
        return list;
    }


    public List<Tag> getAllTag() {
        return tagMapper.getAllTag();
    }


}
