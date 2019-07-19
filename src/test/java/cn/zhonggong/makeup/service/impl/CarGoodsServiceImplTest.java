package cn.zhonggong.makeup.service.impl;

import cn.zhonggong.makeup.domain.CarGoods;
import cn.zhonggong.makeup.enums.ResultEnum;
import cn.zhonggong.makeup.service.CarGoodsService;
import org.hibernate.validator.constraints.EAN;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 军辉
 * 2019-07-19 19:46
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CarGoodsServiceImplTest {

    @Autowired
    private CarGoodsService carGoodsService;

    @Test
    public void addCarGoods() {
        CarGoods carGoods = new CarGoods();
        carGoods.setCarId(8);
        carGoods.setUserId(8);
        carGoods.setGoodsId(44);
        carGoods.setGoodsName("染唇液");
        carGoods.setGoodsPrice(new BigDecimal(340.0));

        Assert.assertNotEquals(carGoodsService.addCarGoods(carGoods).getCode(), ResultEnum.RESULT_ENUM_FAIL.getCode());
    }

    @Test
    public void deleteCarGoodsByGoodsId() {
        Assert.assertNotEquals(carGoodsService.deleteCarGoodsByGoodsId(1), ResultEnum.RESULT_ENUM_FAIL.getCode());
    }

    @Test
    public void selectCarGoodsByUserId() {
        List<CarGoods> carGoodsList = (List<CarGoods>) carGoodsService.selectCarGoodsByUserId(8).getData();
        //System.out.println(carGoodsList);
        Assert.assertNotNull(carGoodsList);
    }
}