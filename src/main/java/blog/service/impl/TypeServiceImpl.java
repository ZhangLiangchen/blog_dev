package blog.service.impl;

import blog.entity.Type;
import blog.mapper.TypeMapper;
import blog.service.TypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements TypeService {
    @Resource
    TypeMapper typeMapper;

    public List<Type> queryBlogById(Long id){
        return typeMapper.queryBlogById(id);
    }

    @Override
    public void deleteById(Long id) {
        typeMapper.deleteById(id);
    }
}
