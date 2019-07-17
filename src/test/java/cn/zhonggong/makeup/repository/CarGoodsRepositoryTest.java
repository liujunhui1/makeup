package cn.zhonggong.makeup.repository;

import cn.zhonggong.makeup.domain.CarGoods;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * 军辉
 * 2019-07-17 19:12
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class CarGoodsRepositoryTest {

    @Autowired
    private CarGoodsRepository carGoodsRepository;

    @Test
    public void add() {
        CarGoods carGoods = new CarGoods(1, 1, 1, "1", new BigDecimal(1.2), 1);
        System.out.println(carGoodsRepository.save(carGoods));
    }

}