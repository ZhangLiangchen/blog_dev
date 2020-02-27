package blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Ciel-08
 * @date 2020/2/24 19:52
 */
@Controller
@RequestMapping("/admin")
public class BlogController {

    @GetMapping("/blogs")
    public String listBlog() {
        return "admin/blogs";
    }

    @GetMapping("/blog/input")
    public String createBlog() {

        return "admin/blog-input";
    }

}
