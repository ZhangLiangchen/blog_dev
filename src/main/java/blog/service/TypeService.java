package blog.service;

import blog.entity.Type;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface TypeService extends IService<Type> {

    List<Type> queryBlogById(Long id);

    void deleteById(Long id);

    boolean isExistByTypeName(String name);
}
