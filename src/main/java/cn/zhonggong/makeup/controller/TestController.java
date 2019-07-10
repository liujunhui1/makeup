package cn.zhonggong.makeup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 军辉
 * 2019-07-10 17:07
 */
@Controller
public class TestController {

    @GetMapping("/test")
    public ModelAndView test(){
        return new ModelAndView("test");
    }
}
