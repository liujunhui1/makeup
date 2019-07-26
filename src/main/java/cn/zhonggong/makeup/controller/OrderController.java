package cn.zhonggong.makeup.controller;

import cn.zhonggong.makeup.domain.Order;
import cn.zhonggong.makeup.service.OrderService;
import cn.zhonggong.makeup.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * 军辉
 * 2019-07-13 15:51
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/toselectorders")
    public ModelAndView toselectorders() {
        return new ModelAndView("/part/order");
    }

    @GetMapping("/toaddorders")
    public ModelAndView toaddorders() {
        return new ModelAndView("/part/addOrder");
    }


    @GetMapping("/getorders")
    public ResultVO getorders(@RequestParam(defaultValue = "1", name = "page") int size,
                              @RequestParam(defaultValue = "10", name = "limit") int limit,
                              @RequestParam(defaultValue = "", name = "search") String search) {
        return orderService.selectOrders(size - 1, limit, search);

    }

    @PostMapping("/addorder")
    public ResultVO addorder(Order order) {
        return orderService.save(order);
    }

    @DeleteMapping("/deletebyid")
    public ResultVO deleteById(@RequestParam(value = "id", required = true) int id) {
        return orderService.deleteById(id);
    }
}
