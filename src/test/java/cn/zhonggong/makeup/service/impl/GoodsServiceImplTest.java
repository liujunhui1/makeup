package cn.zhonggong.makeup.service.impl;

import cn.zhonggong.makeup.domain.Goods;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.rmi.runtime.Log;

import java.util.List;

import static org.junit.Assert.*;

/**
 * 军辉
 * 2019-07-15 9:05
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class GoodsServiceImplTest {

    @Autowired
    private GoodsServiceImpl goodsService;

    @Test
    public void findAllGoods() {
        List<Goods> goodsList = goodsService.findAllGoods();
        System.out.println(goodsList.size());
        Assert.assertNotNull(goodsList);
    }


    @Test
    public void save() {
        Goods goods = new Goods();
        goods.setGoodsName("name");
        goods.setGoodsDescribe("卡接电话白金卡送大奖是");

        int code = goodsService.save(goods).getCode();
        Assert.assertNotEquals(code, "0");
    }
}