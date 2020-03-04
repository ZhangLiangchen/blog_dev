package blog.service.impl;

import blog.entity.Blog;
import blog.mapper.BlogMapper;
import blog.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service("BlogServiceImpl")
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {
}
