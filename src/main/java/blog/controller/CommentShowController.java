package blog.controller;


import blog.entity.Comment;
import blog.service.BlogService;
import blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

//博客评论
@Controller
public class CommentShowController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/comments/{blogId}")
    public String comments(@PathVariable Long blogId, Model model) {
        model.addAttribute("comments", commentService.listCommentByBlogId(blogId));
        return "blog :: commentList";
    }

    @PostMapping("/comments")
    public String post(Comment comment) {
        Long blogId = comment.getBlog().getId();
        comment.setBlog(blogService.getDetailedBlog(blogId));
        commentService.saveComment(comment);
        return "redirect:/comments/" + blogId;
    }
//    @PostMapping("/comments")
//    public String post(Comment comment) {
//        Long blogId = comment.getBlog().getId();
//        comment.setBlog(blogService.getBlog(blogId));
//        commentService.saveComment(comment);
//        return "redirect:/comments/" + blogId;
//    }
}