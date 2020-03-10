package blog.controller;


import blog.dto.FirstPageBlog;
import blog.entity.Type;
import blog.service.BlogService;
import blog.service.TypeService;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//查看分类
@Controller
public class TypeShowController {

    @Autowired
    TypeService typeService;
    @Autowired
    BlogService blogService;

    @GetMapping("/types/{id}")
    public String types(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, @PathVariable Long id, Model model){
        //查询出表里所有分类名称存于list中
        List<Type> typeList=typeService.list();
        //经过筛选后返回给前台的list
        List<Type> keyList=new ArrayList<>();
        for(Type t:typeList) {
            List<Type> blogList=typeService.queryBlogById(t.getId());
            for(Type t1:blogList){
                t.setBlogsNum(t1.getBlogs().size());
                if(t.getBlogsNum()>0){
                    keyList.add(t);
                }
            }
        }
        if (id == -1) {
            id = typeList.get(0).getId();
        }
        PageHelper.startPage(pageNum, 2);
        List<FirstPageBlog> blogs = blogService.getByTypeId(id);
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("types",keyList);
        model.addAttribute("activeTypeId", id);
        return "types";
    }



}
