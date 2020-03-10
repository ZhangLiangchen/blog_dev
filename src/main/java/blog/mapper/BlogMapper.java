package blog.mapper;

import blog.dto.BlogTable;
import blog.dto.DetailedBlog;
import blog.dto.FirstPageBlog;
import blog.dto.RecommendBlog;
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

    List<BlogTable> getBlogTable();

}
