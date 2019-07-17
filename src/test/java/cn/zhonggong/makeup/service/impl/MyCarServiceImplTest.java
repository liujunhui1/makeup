package cn.zhonggong.makeup.service.impl;

import cn.zhonggong.makeup.domain.CarGoods;
import cn.zhonggong.makeup.domain.Goods;
import cn.zhonggong.makeup.domain.MyCar;
import cn.zhonggong.makeup.repository.CarGoodsRepository;
import cn.zhonggong.makeup.service.GoodsService;
import cn.zhonggong.makeup.service.MyCarService;
import cn.zhonggong.makeup.util.TransUtil;
import cn.zhonggong.makeup.vo.CarVO;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.loader.plan.build.internal.LoadGraphLoadPlanBuildingStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.ElementCollection;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * 军辉
 * 2019-07-17 10:46
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class MyCarServiceImplTest {

    @Autowired
    private MyCarService carService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private CarGoodsRepository goodsRepository;


    @Test
    public void add() {
        MyCar myCar = new MyCar();
        myCar.setUserId(6);
        List<CarGoods> list = new ArrayList<>();
        Goods goods1 = (Goods) goodsService.findById(1).getData();
        CarGoods carGoods1 = TransUtil.goods2CarGoods(goods1);
        carGoods1.setCarId(6);
        System.out.println(carGoods1);
        list.add(carGoods1);
        goodsRepository.save(carGoods1);

        Goods goods2 = (Goods) goodsService.findById(10).getData();
        CarGoods carGoods2 = TransUtil.goods2CarGoods(goods1);
        carGoods2.setCarId(6);
        list.add(carGoods2);
        goodsRepository.save(carGoods2);


        myCar.setFreight(new BigDecimal(10.5));
        myCar.setTotalPrice(goods1.getPrice().add(goods1.getPrice()).add(myCar.getFreight()));

        carService.add(myCar);

        CarVO carVO = new CarVO(myCar.getUserId(), myCar.getFreight(), myCar.getTotalPrice(), list);
        System.out.println(carVO);

    }
}