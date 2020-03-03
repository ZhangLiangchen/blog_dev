package blog.service.impl;

import blog.entity.User;
import blog.mapper.UserMapper;
import blog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
