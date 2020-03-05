package blog.service;

import blog.entity.TType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface TypeService extends IService<TType> {

    List<TType> queryBlogById(Long id);

    void deleteById(Long id);
}
