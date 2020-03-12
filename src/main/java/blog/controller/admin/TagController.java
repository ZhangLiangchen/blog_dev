package blog.controller.admin;


import blog.entity.Tag;
import blog.service.TagService;

import java.lang.String;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
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

        System.out.println(tag.getName());

        Tag tag1 = tagService.getByName(tag.getName());
        if (tag1 != null) {
            //不为空说明数据库已有
            attributes.addFlashAttribute("message", "已有这个标签，不能重复添加");
            return "redirect:/admin/tag/input";
        }
        List<Tag> list=tagService.list();
        int id1=list.size();
        int id2=id1+1;
        Long id3= Long.valueOf(id2);
        Tag type2=list.get(id1-1);
        System.out.println(type2);
        if(type2.getId()>list.size()){
            tag.setId(type2.getId()+1);
        }
        else{
            tag.setId(id3);
        }
        System.out.println(tag.getId());
        int t = tagService.saveTag(tag);
        if(t==1)
        {
            attributes.addFlashAttribute("message", "新增成功");
        }else{
            attributes.addFlashAttribute("message", "新增失败");
        }
        System.out.println(t);
        return "redirect:/admin/tag";
    }

    @GetMapping("/tag/{id}/input")
    public String editInput(@PathVariable Long id,Model model) {
        model.addAttribute("tag", tagService.getById(id));
        return "admin/tag-update";
    }

    @PostMapping("/tag/update")
    public String editPost(Tag tag,RedirectAttributes attributes) {

        Tag tag1 = tagService.getByName(tag.getName());
        if (tag1 != null) {
            //不为空说明数据库已有
            attributes.addFlashAttribute("message", "已有这个标签，不能重复添加");
            return "redirect:/admin/tag/input";
        }
        int t=tagService.updateTag(tag);
        if(t==1)
        {
            attributes.addFlashAttribute("message","更新成功！");
        }else
        {
            attributes.addFlashAttribute("message","更新失败！");
        }
        return "redirect:/admin/tag";
    }

    @GetMapping("/tag/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes) {
        tagService.deleteTag(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/tag";
    }

}
