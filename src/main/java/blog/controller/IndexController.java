package blog.controller;


import blog.dto.FirstPageBlog;
import blog.dto.RecommendBlog;
import blog.entity.Tag;
import blog.entity.Type;
import blog.service.BlogService;
import blog.service.CommentService;
import blog.service.TagService;
import blog.service.TypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//首页
@Controller
public class IndexController {

    private final BlogService blogService;

    private final TagService tagService;

    private final TypeService typeService;

    private final CommentService commentService;

    public IndexController(BlogService blogService, TagService tagService, TypeService typeService, CommentService commentService) {
        this.blogService = blogService;
        this.tagService = tagService;
        this.typeService = typeService;
        this.commentService = commentService;
    }

    /**
     * 语法：@RequestParam(value=”参数名”,required=”true/false”,defaultValue=””)
     * <p>
     * value：参数名
     * <p>
     * required：是否包含该参数，默认为true，表示该请求路径中必须包含该参数，如果不包含就报错。
     * <p>
     * defaultValue：默认参数值，如果设置了该值，required=true将失效，自动为false,如果没有传该参数，就使用默认值
     */
    @GetMapping("/")
    public String index(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 6);
        List<FirstPageBlog> allFirstPageBlogList = blogService.getAllFirstPageBlog();
        List<Type> allType = typeService.list();
        List<Tag> allTag = tagService.list();
        List<RecommendBlog> recommendBlogs = blogService.getRecommendedBlog();
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(allFirstPageBlogList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("tags", allTag);
        model.addAttribute("types", allType);
        model.addAttribute("recommendedBlogs", recommendBlogs);
        return "index";
    }
}
