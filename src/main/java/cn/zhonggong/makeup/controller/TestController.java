package cn.zhonggong.makeup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 军辉
 * 2019-07-10 17:07
 */
@Controller
public class TestController {

    @GetMapping("/test")
    public ModelAndView test() {
        System.out.println("test");
        return new ModelAndView("test");
    }

    @PostMapping("/index")
    public ModelAndView Post_index() {
        System.out.println("Post_index");
        return new ModelAndView("index");
    }

    @GetMapping("/index")
    public ModelAndView Get_index() {
        System.out.println("Get_index");
        return new ModelAndView("index");
    }

    @GetMapping("/login")
    public ModelAndView login() {
        System.out.println("login");
        return new ModelAndView("login");
    }
}
