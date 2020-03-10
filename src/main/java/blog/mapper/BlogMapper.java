package blog.mapper;

import blog.dto.*;
import blog.entity.Blog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BlogMapper extends BaseMapper<Blog> {

    List<FirstPageBlog> getFirstPageBlog();

    List<RecommendBlog> getAllRecommendBlog();

    List<FirstPageBlog> getSearchBlog(String query);

    DetailedBlog getDetailedBlog(Long id);

    List<BlogTable> getBlogTable(SearchBlog searchBlog);


    //根据TypeId获取博客列表，在分类页进行的操作
    List<FirstPageBlog> getByTypeId(Long typeId);
}
