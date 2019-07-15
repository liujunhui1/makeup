package cn.zhonggong.makeup.controller;

import cn.zhonggong.makeup.domain.Goods;
import cn.zhonggong.makeup.service.GoodsService;
import cn.zhonggong.makeup.service.impl.GoodsServiceImpl;
import cn.zhonggong.makeup.util.ResultVOUtil;
import cn.zhonggong.makeup.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 军辉
 * 2019-07-13 15:51
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/togoods", method = RequestMethod.GET)
    public ModelAndView toUser(Model model) {
        return new ModelAndView("/part/selectgoods");
    }

    @GetMapping("/addgoods")
    public ModelAndView addPage(){
        return new ModelAndView("/part/addGoods");
    }


//    @GetMapping("/getall")
//    public ResultVO getAllGoods() {
//        List<Goods> goods = goodsService.findAllGoods();
//        if (goods == null || goods.size() == 0) {
//            return ResultVOUtil.Fail("查询商品数量为空");
//        } else {
//            return ResultVOUtil.Success("查询成功", goods.size(), goods);
//        }
//    }


    @RequestMapping(value = "/goods", method = RequestMethod.GET)
    public ResultVO<Object> selectGoods(@RequestParam(defaultValue = "1", name = "page") int page,
                                        @RequestParam(defaultValue = "10", name = "limit") int limit,
                                        @RequestParam(defaultValue = "", name = "search") String search) {
        return goodsService.selectGoods(page - 1, limit, search);
    }

}
