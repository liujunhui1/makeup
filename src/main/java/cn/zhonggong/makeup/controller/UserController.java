package cn.zhonggong.makeup.controller;

import cn.zhonggong.makeup.domain.User;
import cn.zhonggong.makeup.service.impl.UserServiceImpl;
import cn.zhonggong.makeup.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 军辉
 * 2019-07-11 20:17
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/login")
    public ResultVO login(User user) {
        return userService.login(user);
    }

    @PostMapping("/register")
    public ResultVO register(User user) {
        return userService.save(user);
    }

}
