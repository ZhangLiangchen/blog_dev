package blog.controller;


import blog.entity.Comment;
import blog.entity.User;
import blog.service.BlogService;
import blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

//博客评论
@Controller
public class CommentShowController {
    @Autowired
    private CommentService commentService;

    @Value("${comment.avatar}")
    private String avatar;

    @Autowired
    private BlogService blogService;


    @GetMapping("/comments/{blogId}")
    public String comments(@PathVariable Long blogId, Model model) {
        List<Comment> comments = commentService.listComment(blogId);
        model.addAttribute("comments", comments);
        model.addAttribute("blog", blogService.getDetailedBlog(blogId));
        return "blog";
    }

    @PostMapping("/comments")
    public String post(Comment comment,HttpSession session) {
        Long blogId = comment.getBlogId();
        comment.setBlog(blogService.getDetailedBlog(blogId));
        //设置头像
        comment.setAvatar(avatar);
        User user = (User) session.getAttribute("user");
        if (user != null) {
            comment.setAvatar(user.getAvatar());
            comment.setAdminComment(true);
        } else {
            comment.setAvatar(avatar);
        }
        if (comment.getParentComment().getId() != null) {
            comment.setParentCommentId(comment.getParentComment().getId());
        }
        commentService.saveComment(comment);
        return "redirect:/comments/" + blogId;
    }
}