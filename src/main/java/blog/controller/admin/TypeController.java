package blog.controller.admin;


import blog.entity.Type;
import blog.service.TypeService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//分类管理
@RestController
@RequestMapping("/admin")
public class TypeController {

    @Resource
    TypeService typeService;

    @GetMapping("/type")
    public ModelAndView type(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("admin/types");
        return mv;
    }

    @GetMapping("/typeList")
    @ResponseBody
    public Map<String, Object> typeList(@RequestParam(required = false,defaultValue = "1",value = "page")Integer page,
                                        @RequestParam(required = false,defaultValue = "10",value = "limit")Integer limit){

        PageHelper.startPage(page,limit);
        List<Type> list=typeService.list();
        for(Type t:list){
            List<Type> list1=typeService.queryBlogById(t.getId());
            System.out.println(list1.size());
            for(Type t1:list1){
                System.out.println(t1.toString());
                t.setBlogsNum(t1.getBlogs().size());
            }
        }
       PageInfo<Type> pageInfo=new PageInfo<>(list,limit);
        Map<String,Object> result = new HashMap<>(16);
        result.put("code", 0);
        result.put("msg", "");
        result.put("count", pageInfo.getTotal());
        result.put("data", list);
        return result;

    }

    @GetMapping("/typeUpdate")
    public String updateType(Type type){
        typeService.updateById(type);

        return "success";
    }

    @GetMapping("/typeUpdateAndAddUI")
    public ModelAndView updateUI(HttpServletRequest request, @RequestParam(required = false,value = "id")Long  id) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(id);
        modelAndView.addObject("id",id);
        if(id!=null) {
            modelAndView.setViewName("admin/types-update");
        }else{
            modelAndView.setViewName("admin/types-add");
        }
        return modelAndView;
    }

    @PostMapping("/deleteType")
    public void  delete(HttpServletResponse response, @RequestParam(required = false,value = "id")Long  id) throws IOException {
        System.out.println(id);
        typeService.deleteById(id);
        response.sendRedirect("/admin/typeList");

    }

    @GetMapping("/addType")
    public String add(HttpServletResponse response,Type type){
        //保证所有的分类id都是递增+1的
        List<Type> list=typeService.list();
        int id1=list.size();
        int id2=id1+1;
        Long id3= Long.valueOf(id2);
        Type type2=list.get(id1-1);
        if(type2.getId()>list.size()){
            type.setId(type2.getId()+1);
        }
        else{
            type.setId(id3);
        }
        System.out.println("6666666666");
        System.out.println(type.getName());
        typeService.save(type);
        return "success";

    }



}
