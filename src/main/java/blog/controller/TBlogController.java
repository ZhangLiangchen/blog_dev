package blog.controller;

import blog.service.TBlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (TBlog)表控制层
 *
 * @author makejava
 * @since 2020-02-29 20:41:29
 */
@Controller
@RequestMapping("/admin")
public class TBlogController {

    @Resource
    private TBlogService tBlogService;

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