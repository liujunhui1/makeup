package cn.zhonggong.makeup.service.impl;

import cn.zhonggong.makeup.domain.GoodsType;
import cn.zhonggong.makeup.repository.GoodsTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 军辉
 * 2019-07-15 9:43
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class GoodsTypeServiceImplTest {

    @Autowired
    private GoodsTypeServiceImpl goodsTypeService;

    @Autowired
    private GoodsTypeRepository goodsTypeRepository;

    @Test
    public void save() {
        GoodsType goodsType = new GoodsType(998, "test一级分类", "test二级分类");
        System.out.println(goodsTypeService.save(goodsType));
    }

    @Test
    public void findMainName() {

        List<String> mainNameList = goodsTypeService.findMainName();
        log.info(mainNameList.toString());
        //Arrays.asList(mainNameList);
        Assert.assertNotNull(mainNameList);

    }

    @Test
    public void findChildName() {
        List<String> childNameList = goodsTypeRepository.findChildName();
        log.info(childNameList.toString());
        Assert.assertNotNull(childNameList);
    }
}