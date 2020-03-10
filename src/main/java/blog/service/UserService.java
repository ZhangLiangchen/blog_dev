package blog.service;

import blog.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

public interface UserService extends IService<User> {

    User userLogin(User user);

    User getByUserName(String username);
}
