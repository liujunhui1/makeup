package cn.zhonggong.makeup.controller;

import cn.zhonggong.makeup.domain.CarGoods;
import cn.zhonggong.makeup.util.ResultVOUtil;
import cn.zhonggong.makeup.vo.CarVO;
import cn.zhonggong.makeup.vo.ResultVO;
import org.hibernate.validator.constraints.EAN;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * 军辉
 * 2019-07-17 19:23
 */
@Repository
@RequestMapping("car")
public class MyCarController {

    @PostMapping("addcar")
    public ResultVO addCar(@RequestParam(value = "userId", required = true) int userId,
                           @RequestParam(value = "carGoods", required = true) List<CarGoods> carGoods) {

        List<CarGoods> carGoodsList = new ArrayList<>();
        for (CarGoods car : carGoods) {
            carGoodsList.add(car);
        }
        CarVO carVO = new CarVO();
        carVO.setCarGoods(carGoodsList);
        carVO.setUserId(userId);
        return ResultVOUtil.Success("增加购物车成功", carGoodsList.size(), carVO);

    }

}
