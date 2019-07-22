package cn.zhonggong.makeup.controller;

import cn.zhonggong.makeup.domain.CarGoods;
import cn.zhonggong.makeup.service.CarGoodsService;
import cn.zhonggong.makeup.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 军辉
 * 2019-07-19 21:38
 */
@RestController
@RequestMapping("/cargoods")
public class CarGoodsController {

    @Autowired
    private CarGoodsService carGoodsService;


    @PostMapping("/addcargoods")
    public ResultVO addCarGoods(CarGoods cargoods) {
        return carGoodsService.addCarGoods(cargoods);
    }


    @GetMapping("/findbygoodsid")
    public ResultVO selectCarGoodsByGoodsId(@RequestParam(value = "goodsId", required = true) int goodsId) {
        return carGoodsService.selectCarGoodsByGoodsId(goodsId);
    }


    @DeleteMapping("/deletebygoodsid")
    public ResultVO deleteCarGoodsByGoodsId(@RequestParam(value = "goodsId", required = true) int goodsId) {
        return carGoodsService.deleteCarGoodsByGoodsId(goodsId);
    }

    @GetMapping("/findbyuserid")
    public ResultVO selectCarGoodsByUserId(@RequestParam(value = "userId", required = true) int userId) {
        return carGoodsService.selectCarGoodsByUserId(userId);
    }

    @DeleteMapping("/deletebyid")
    public ResultVO deleteCarGoodsById(@RequestParam(value = "id", required = true) int id) {
        return carGoodsService.deleteCarGoodsById(id);
    }
}
