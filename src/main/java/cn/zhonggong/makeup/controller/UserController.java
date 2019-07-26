package cn.zhonggong.makeup.controller;

import cn.zhonggong.makeup.domain.User;
import cn.zhonggong.makeup.enums.UserTypeEnum;
import cn.zhonggong.makeup.service.impl.UserServiceImpl;
import cn.zhonggong.makeup.util.ResultVOUtil;
import cn.zhonggong.makeup.vo.ResultVO;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/user")
    public ModelAndView user() {
        return new ModelAndView("/part/user");
    }

    @GetMapping("/adduser")
    public ModelAndView addUser() {
        return new ModelAndView("/part/addUser");
    }

    @GetMapping("/toupdateuser")
    public ModelAndView updateUser() {
        return new ModelAndView("/part/updateUser");
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
        return userService.registerUser(user);
    }

    @GetMapping("/index")
    public ModelAndView Get_index() {
        User CurrentUser = (User) httpSession.getAttribute("user");
        if (CurrentUser == null) {
            return new ModelAndView("login");
        }
        if (UserTypeEnum.USER_TYPE_ADMIN.getCode().equals(CurrentUser.getUserType())) {
            //TODO
            //非管理员账户不能登录后台页面
            //  return ResultVOUtil.Success("管理员登录后台成功", 1, CurrentUser);
            return new ModelAndView("/index.html");
        }
        return new ModelAndView("/login.html");
    }

    @GetMapping("/findbyaccount")
    public ResultVO findByAccount(@RequestParam(value = "userAccount", required = true) String userAccount) {
        return userService.findByAccount(userAccount);
    }

    @PutMapping("/updateuser")
    public ResultVO updateUser(User user) {
        return userService.updateUser(user);
    }

    @GetMapping("/findall")
    public ResultVO findAll() {
        return userService.findAll();
    }

    @DeleteMapping("/deletebyid")
    public ResultVO deleteById(@RequestParam(value = "id", required = true) int id) {
        return userService.deleteById(id);
    }

    @PostMapping("/adminlogin")
    public ResultVO adminLogin(User user) {
        return userService.adminLogin(user);
    }
}
