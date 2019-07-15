package cn.zhonggong.makeup.controller;

import cn.zhonggong.makeup.domain.User;
import cn.zhonggong.makeup.enums.UserTypeEnum;
import cn.zhonggong.makeup.service.impl.UserServiceImpl;
import cn.zhonggong.makeup.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * 军辉
 * 2019-07-11 20:17
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private HttpSession httpSession;


    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("register");
    }

    @PostMapping("/login")
    public ResultVO login(User user) {
        return userService.login(user);
    }

    @PostMapping("/register")
    public ResultVO register(User user) {
        return userService.save(user);
    }

    @GetMapping("/index")
    public ModelAndView Get_index() {
        User CurrentUser = (User) httpSession.getAttribute("user");
        if (CurrentUser.getUserType() != UserTypeEnum.USER_TYPE_ADMIN.getCode()) {
            //TODO
            //非管理员账户不能登录后台页面
        }

        return new ModelAndView("index");
    }

}
