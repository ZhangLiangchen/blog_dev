package blog.controller.admin;


import blog.dto.BlogAndTag;
import blog.dto.BlogTable;
import blog.dto.SearchBlog;
import blog.entity.Blog;
import blog.entity.Tag;
import blog.entity.Type;
import blog.service.BlogService;
import blog.service.TagService;
import blog.service.TypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * 博客管理模块
 * @author 浅忆
 *
 */
@Controller
@RequestMapping("/admin")
public class BlogController {

    @Resource
    private BlogService blogService;
    @Resource
    private TypeService typeService;
    @Resource
    private TagService tagService;

    /**
     * 进入博客管理首页，若为查询操作，向页面传递查询条件
     */
    @RequestMapping("/blogs")
    public String manageBlog(Model model,SearchBlog searchBlog) {
        List<Type> types = typeService.list();
        model.addAttribute("types", types);
        model.addAttribute("condition", searchBlog);
        return "admin/blogs";
    }
    /**
     * 博客列表组合条件查询，返回json数据
     */
    @ResponseBody
    @RequestMapping("/blogs/list")
    public Map<String,Object> listBlog(SearchBlog searchBlog, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<BlogTable> blogs = blogService.getBlogTable(searchBlog);
        PageInfo<BlogTable> pageInfo = new PageInfo<>(blogs, limit);
        Map<String,Object> result = new HashMap<>(16);
        result.put("count", pageInfo.getTotal());
        result.put("data", blogs);
        result.put("message", "");
        result.put("code", 0);
        return result;
    }

    /**
     * 进入编辑博客页面，传入id为0表示新增
     */
    @GetMapping("/blog/input/{id}")
    public String editBlog(@PathVariable(value = "id", required = false) Long id, Model model) {
        Blog blog = new Blog();
        if (id != 0) {
            blog = blogService.getById(id);
        }
        List<Type> types = typeService.list();
        model.addAttribute("b", blog);
        model.addAttribute("types", types);
        return "admin/blog-input";
    }

    /**
     * 返回标签数据，供博主在弹出层选择
     */
    @GetMapping("/blog/input/selectTags")
    public String selectTags(Model model, String tagIds) {
        List<Tag> tags = tagService.list();
        model.addAttribute("tags", tags);
        model.addAttribute("tagsOfBlog", tagIds);
        return "admin/tags-select";
    }

    /**
     * Post请求，保存编辑的博客，包括新增和修改的博客
     */
    @PostMapping("/blog/save")
    public String saveBlog(Blog blog) {
        //如果是新增博客，设置创建时间和初始阅读量
        if (blog.getId() == null) {
            blog.setCreateTime(new Date());
            blog.setViews(0);
            blog.setFlag("原创");
        }
        //更新修改时间
        blog.setUpdateTime(new Date());
        blogService.saveOrUpdate(blog);
        //更新blog-tag多对多中间表
        blogService.setBlogTag(blog.getId(), blog.getTagIds());
        return "redirect:/admin/blogs";
    }

    /**
     * 删除博客
     */
    @GetMapping("/blog/delete/{id}")
    public String deleteBlog(@PathVariable(value = "id", required = false) Long id) {
        if (id != null) {
            //去除中间表关联
            blogService.removeBlogTag(id);
            //删除博客
            blogService.removeById(id);
        }
        return "redirect:/admin/blogs";
    }


}
