package cn.zhonggong.makeup.controller;

import cn.zhonggong.makeup.domain.Goods;
import cn.zhonggong.makeup.service.GoodsService;
import cn.zhonggong.makeup.service.impl.GoodsServiceImpl;
import cn.zhonggong.makeup.service.impl.GoodsTypeServiceImpl;
import cn.zhonggong.makeup.util.ResultVOUtil;
import cn.zhonggong.makeup.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 军辉
 * 2019-07-13 15:51
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsServiceImpl goodsService;


    @GetMapping("/getall")
    public ResultVO getAllGoods() {
        List<Goods> goods = goodsService.findAllGoods();
        if (goods == null || goods.size() == 0) {
            return ResultVOUtil.Fail("查询商品数量为空");
        } else {
            return ResultVOUtil.Success("查询成功", goods.size(), goods);
        }
    }


}
