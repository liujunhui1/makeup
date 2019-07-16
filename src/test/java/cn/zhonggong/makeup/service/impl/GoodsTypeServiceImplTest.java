package cn.zhonggong.makeup.service.impl;

import cn.zhonggong.makeup.domain.GoodsType;
import cn.zhonggong.makeup.enums.ResultEnum;
import cn.zhonggong.makeup.repository.GoodsTypeRepository;
import cn.zhonggong.makeup.service.GoodsTypeService;
import cn.zhonggong.makeup.util.ResultVOUtil;
import cn.zhonggong.makeup.vo.ResultVO;
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
    private GoodsTypeService goodsTypeService;

    @Test
    public void save() {
        GoodsType goodsType = new GoodsType(998, "test一级分类", "test二级分类");
        Assert.assertNotEquals(goodsTypeService.save(goodsType), ResultEnum.RESULT_ENUM_SUCCESS.getCode());
    }

    @Test
    public void findMainName() {

        //Arrays.asList(mainNameList);
        Assert.assertNotEquals(goodsTypeService.findMainName().getCode(), ResultEnum.RESULT_ENUM_FAIL.getCode());

    }

    @Test
    public void findChildName() {

        Assert.assertNotEquals(goodsTypeService.findChildName().getCode(), ResultEnum.RESULT_ENUM_FAIL.getCode());
    }
}