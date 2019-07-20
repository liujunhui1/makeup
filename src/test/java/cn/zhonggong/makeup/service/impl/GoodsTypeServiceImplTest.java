package cn.zhonggong.makeup.service.impl;

import cn.zhonggong.makeup.service.GoodsTypeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springfox.documentation.service.ApiListing;

import java.util.List;

import static org.junit.Assert.*;

/**
 * 军辉
 * 2019-07-16 21:10
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class GoodsTypeServiceImplTest {

    @Autowired
    private GoodsTypeService goodsTypeService;


    @Test
    public void save() {
    }

    @Test
    public void findMainName() {
    }

    @Test
    public void findChildName() {
    }

    @Test
    public void findChildNameByMainId() {
    }

    @Test
    public void getNavigation() {
        goodsTypeService.getNavigation();
    }

    @Test
    public void findChildNameByMainName() {
        List<String> childNames = goodsTypeService.findChildNameByMainName("彩妆");
        log.info(childNames + "");
        Assert.assertNotNull(childNames);
    }

    @Test
    public void findMainNameByChildId() {


        String mainName = goodsTypeService.findMainNameByChildId(12);
        log.info("mainName:" + mainName);
        String childName = goodsTypeService.findChildNameByChildId(12);
        log.info("childName" + childName);
    }
}