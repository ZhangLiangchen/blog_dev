package blog.service;

import blog.dto.DetailedBlog;
import blog.dto.FirstPageBlog;
import blog.dto.RecommendBlog;
import blog.entity.Blog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface BlogService extends IService<Blog> {
    List<FirstPageBlog> getAllFirstPageBlog();

    List<RecommendBlog> getRecommendedBlog();

    List<FirstPageBlog> getSearchBlog(String query);

    DetailedBlog getDetailedBlog(Long id);
}
