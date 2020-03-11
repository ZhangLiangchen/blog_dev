package blog.service.impl;

import blog.dto.*;
import blog.entity.Blog;
import blog.entity.Type;
import blog.exception.NotFountException;
import blog.mapper.BlogMapper;
import blog.mapper.TypeMapper;
import blog.service.BlogService;
import blog.util.MarkdownUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional(rollbackFor = Exception.class)
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public List<FirstPageBlog> getAllFirstPageBlog() {
        return blogMapper.getFirstPageBlog();
    }

    @Override
    public List<RecommendBlog> getRecommendedBlog() {
        List<RecommendBlog> allRecommendBlog = blogMapper.getAllRecommendBlog();
        List<RecommendBlog> allRecommendedBlog = new ArrayList<>();
        for (RecommendBlog recommendBlog : allRecommendBlog) {
            if (recommendBlog.isRecommend()) {
                allRecommendedBlog.add(recommendBlog);
            }
        }
        return allRecommendedBlog;
    }

    @Override
    public List<FirstPageBlog> getSearchBlog(String query) {
        return blogMapper.getSearchBlog(query);
    }

    @Override
    public DetailedBlog getDetailedBlog(Long id) {
        DetailedBlog detailedBlog = blogMapper.getDetailedBlog(id);
        if (detailedBlog == null) {
            throw new NotFountException("该博客不存在");
        }
        String content = detailedBlog.getContent();
        detailedBlog.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        return detailedBlog;
    }

    @Override
    public List<BlogTable> getBlogTable(SearchBlog searchBlog) {

        //日期条件处理
        String date = searchBlog.getDate();
        if (date != null && !date.equals("")) {
            String[] yearAndMonth = date.split("-");
            int year = Integer.parseInt(yearAndMonth[0]);
            int month = Integer.parseInt(yearAndMonth[1]);
            if (month == 12) {
                year++;
                month = 1;
            } else {
                month++;
            }
            String nextDate = year + "-" + month;
            searchBlog.setNextDate(nextDate);
        }

        List<BlogTable> blogs = blogMapper.getBlogTable(searchBlog);
        for (BlogTable blog : blogs) {
            //发布状态处理
            if (blog.getPublished() == true) {
                blog.setState("已发布");
            } else {
              blog.setState("草稿箱");
            }
        }
        return blogs;
    }

    @Override
    public void setBlogTag(Long blogId, String tagIds) {
        //删除旧标签关联
        blogMapper.deleteBlogTag(blogId);
        //设置新关联数组
        List<BlogAndTag> blogAndTags = new ArrayList<>();
        if (tagIds != null && !"".equals(tagIds)) {
            String[] ids = tagIds.split(",");
            //循环插入多对多中间表
            for (String tagId : ids) {
                blogMapper.setBlogTag(new BlogAndTag(blogId, Long.parseLong(tagId)));
            }
        }
    }

    @Override
    public void removeBlogTag(Long blogId) {
        blogMapper.deleteBlogTag(blogId);
    }

    @Override
    public List<FirstPageBlog> getByTypeId(Long typeId) {
        return blogMapper.getByTypeId(typeId);
    }

    @Override
    public List<FirstPageBlog> getByTagId(Long tagId) {
        return blogMapper.getByTagId(tagId);
    }
}
