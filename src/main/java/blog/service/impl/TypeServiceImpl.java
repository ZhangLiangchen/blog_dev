package blog.service.impl;

import blog.entity.Type;
import blog.mapper.TypeMapper;
import blog.service.TypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service("TypeServiceImpl")
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements TypeService {
}
