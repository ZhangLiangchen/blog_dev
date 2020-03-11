package blog.controller;


import blog.dto.FirstPageBlog;
import blog.entity.Tag;
import blog.service.BlogService;
import blog.service.TagService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

//查看标签
@Controller
public class TagShowController {


    @Autowired
    private TagService tagService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/tag/{id}")
    public String tag(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,
                      @PathVariable Long id, Model model) {
        List<Tag> tag = tagService.getAllTag();
        //-1表示从首页导航点进来的
        if (id == -1) {
            id = tag.get(0).getId();
        }
        model.addAttribute("tag", tag);
        List<FirstPageBlog> blogs = blogService.getByTagId(id);
        /*for ( FirstPageBlog a:blogs) {
            System.out.println(a.getTypeName());
            System.out.println(a.getAvatar());
            System.out.println(a.getDescription());
        }*/
        PageHelper.startPage(pageNum, 100);
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("activeTagId", id);
        return "tag";
    }
}
