package blog.service;

import blog.dto.*;
import blog.entity.Blog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface BlogService extends IService<Blog> {
    List<FirstPageBlog> getAllFirstPageBlog();

    List<RecommendBlog> getRecommendedBlog();

    List<FirstPageBlog> getSearchBlog(String query);

    DetailedBlog getDetailedBlog(Long id);

    List<BlogTable> getBlogTable(SearchBlog searchBlog);

    //根据TypeId获取博客列表，在分类页进行的操作
    List<FirstPageBlog> getByTypeId(Long typeId);

    List<FirstPageBlog> getByTagId(Long tagId);
}
