package blog.controller;


import blog.dto.DetailedBlog;
import blog.dto.FirstPageBlog;
import blog.dto.RecommendBlog;
import blog.entity.Comment;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

//首页
@Controller
public class IndexController {

    @Resource
    private BlogService blogService;

    @Resource
    private TagService tagService;

    @Resource
    private TypeService typeService;

    @Resource
    private CommentService commentService;

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

    @GetMapping("/search")
    public String search(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum, @RequestParam String query) {
        PageHelper.startPage(pageNum, 100);
        List<FirstPageBlog> searchBlog = blogService.getSearchBlog(query);
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(searchBlog);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("query", query);
        return "search";
    }

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id, Model model) {
        DetailedBlog detailedBlog = blogService.getDetailedBlog(id);
        List<Comment> comments = commentService.listCommentByBlogId(id);
        model.addAttribute("comments", comments);
        model.addAttribute("blog", detailedBlog);
        return "blog";
    }
}
