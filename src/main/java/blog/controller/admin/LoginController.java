package blog.controller.admin;


import blog.entity.User;
import blog.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 浅忆
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Resource
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "admin/login";
    }

    @PostMapping("/login")
    @ResponseBody
    public String userLogin(User yh, String vcode, HttpServletRequest request) throws Exception{
        String message;
        String trueCode = (String) request.getSession().getAttribute("trueCode");
        User user = userService.userLogin(yh);
        if (vcode == null || !vcode.toUpperCase().equals(trueCode)){
            message = "errorCode";
        }
        else if (userService.getByUserName(yh.getUsername()) == null){
            message = "noUser";
        }
        else if (user == null){
            message = "errorPw";
        }
        else{
            request.getSession().setAttribute("user", user);
            message = "success";
        }
        return message;
    }

    @RequestMapping("/exit")
    public String exit(HttpServletRequest request) {
        request.getSession().invalidate();
        return "admin/login";
    }

}
