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

    @GetMapping("/toselectgoods")
    public ModelAndView toUser(Model model) {
        return new ModelAndView("/part/selectgoods");
    }

    @GetMapping("/toaddgoods")
    public ModelAndView addPage() {
        return new ModelAndView("/part/addGoods");
    }


    @GetMapping("/getgoods")
    public ResultVO<Object> selectGoods(@RequestParam(defaultValue = "1", name = "page") int page,
                                        @RequestParam(defaultValue = "10", name = "limit") int limit,
                                        @RequestParam(defaultValue = "", name = "search") String search) {
        return goodsService.selectGoods(page - 1, limit, search);
    }

    @PostMapping("/addgoods")
    public ResultVO addgoods(Goods goods) {
        return goodsService.save(goods);
    }

    @GetMapping("/getbymainid")
    public ResultVO findByMainId(@RequestParam(value = "mianId", required = true, defaultValue = "1") int mianId) {
        return goodsService.findByMainId(mianId);
    }

    @GetMapping("/getbychildgoods")
    public ResultVO findByChildId(@RequestParam(value = "childId", required = true, defaultValue = "1") int childId) {
        return goodsService.findByChildId(childId);
    }

}
