package blog.controller.admin;


import blog.entity.Tag;
import blog.service.TagService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.annotation.Resource;
import java.util.List;


//标签管理
@Controller
@RequestMapping("/admin")
public class TagController {

    @Resource
    private TagService tagService;


    @GetMapping("/tag")
    public String list(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 4);
        List<Tag> allTag = tagService.list();
        PageInfo<Tag> pageInfo = new PageInfo<>(allTag);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/tag";
    }

    //去新增页面
    @GetMapping("/tag/input")
    public String toAdd() {
        return "/admin/tag-input";
    }

    @PostMapping("/tag/add")
    public String add(Tag tag, RedirectAttributes attributes) {
        System.out.println("前端传过来的表单" + tag);
        Tag tag1 = tagService.getByName(tag.getName());
        if (tag1 != null) {
            //不为空说明数据库已有
            attributes.addFlashAttribute("message", "已有这个标签，不能添加重复");
            return "redirect:/admin/tag/input";
        }
        tagService.saveTag(tag);
        return "redirect:/admin/tag";
    }

    @GetMapping("/tag/{id}/input")
    public String editInput(@PathVariable Long id,Model model) {
        model.addAttribute("tag", tagService.getById(id));
        return "admin/tag-update";
    }

    @PostMapping("/tag/update")
    public String editPost(Tag tag) {
        tagService.updateTag(tag);
        return "redirect:/admin/tag";
    }

    @GetMapping("/tag/{id}/delete")
    public String delete(@PathVariable Long id) {
        tagService.deleteTag(id);
        return "redirect:/admin/tag";
    }

}
