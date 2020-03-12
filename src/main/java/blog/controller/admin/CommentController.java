package blog.controller.admin;

import blog.dto.BlogTable;
import blog.dto.SearchBlog;
import blog.entity.Comment;
import blog.service.BlogService;
import blog.service.CommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class CommentController {

    @Resource
    private CommentService commentService;

    @ResponseBody
    @RequestMapping("/comments/list")
    public Map<String,Object> listComments( Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
//        List<BlogTable> blogs = blogService.getBlogTable(searchBlog);
//        PageInfo<BlogTable> pageInfo = new PageInfo<>(blogs, limit);
        List<Comment> comments = commentService.list();
        PageInfo<Comment> commentPageInfo = new PageInfo<>(comments, limit);
        Map<String,Object> result = new HashMap<>(16);
        result.put("count",commentPageInfo.getTotal());
        result.put("data", comments);
        result.put("message", "");
        result.put("code", 0);
        return result;
    }

    @GetMapping("/comments/delete/{id}")
    public String deleteBlog(@PathVariable Long id, RedirectAttributes attributes) {
        if (id != null) {
            //去除中间表关联，删除博客记录
            commentService.removeById(id);
        }
        attributes.addAttribute("msg","del");
        return "redirect:/admin/comments";
    }
}
