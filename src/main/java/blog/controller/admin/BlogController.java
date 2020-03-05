package blog.controller.admin;


import blog.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

//博客管理
@Controller
@RequestMapping("/admin")
public class BlogController {

    @Resource
    private BlogService blogService;

    @GetMapping("/blogs")
    public String manageBlog() {
        return "admin/blogs";
    }

    @ResponseBody
    @RequestMapping("/blogs/list")
    public Map<String,Object> listBlog(Model model) {
        Map<String,Object> result = new HashMap<>(16);
        result.put("code", 0);
        return result;
    }

    @GetMapping("/blog/input")
    public String createBlog() {

        return "admin/blog-input";
    }

    @GetMapping("/blog/input/selectTags")
    public String selectTags() {
        return "admin/tags-select";
    }

    @PostMapping("/blogs")
    public String saveBlog() {

        return "redirect:blogs";
    }

}
