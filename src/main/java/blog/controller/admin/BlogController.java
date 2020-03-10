package blog.controller.admin;


import blog.entity.Blog;
import blog.entity.Tag;
import blog.entity.Type;
import blog.service.BlogService;
import blog.service.TagService;
import blog.service.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//博客管理
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
     * 进入博客管理首页
     */
    @GetMapping("/blogs")
    public String manageBlog() {
        return "admin/blogs";
    }

    /**
     * 接收ajax请求返回博客列表数据
     */
    @ResponseBody
    @RequestMapping("/blogs/list")
    public Map<String,Object> listBlog(Model model) {
        List<Blog> blogs = blogService.list();
        Map<String,Object> result = new HashMap<>(16);
        result.put("data", blogs);
        result.put("message", "");
        result.put("count", blogs.size());
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
     * 保存编辑的博客，包括新增和修改的博客
     */
    @PostMapping("/blogs")
    public String saveBlog(Blog blog) {
        //如果是新增博客，设置创建时间和阅读量
        if (blog.getId() == null) {
            blog.setCreateTime(new Date());
            blog.setViews(0);
        }
        blog.setFlag("原创");
        blog.setUpdateTime(new Date());
        blogService.saveOrUpdate(blog);
        return "redirect:/admin/blogs";
    }

    /**
     * 删除博客
     */
    @GetMapping("/blog/delete/{id}")
    public String deleteBlog(@PathVariable(value = "id", required = false) Long id) {
        if (id != null) {
            blogService.removeById(id);
        }
        return "redirect:/admin/blogs";
    }


}
