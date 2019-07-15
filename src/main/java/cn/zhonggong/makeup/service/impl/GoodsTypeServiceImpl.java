package cn.zhonggong.makeup.service.impl;

import cn.zhonggong.makeup.domain.Goods;
import cn.zhonggong.makeup.domain.GoodsType;
import cn.zhonggong.makeup.repository.GoodsTypeRepository;
import cn.zhonggong.makeup.service.GoodsService;
import cn.zhonggong.makeup.service.GoodsTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 军辉
 * 2019-07-15 9:37
 */
@Slf4j
@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Autowired
    private GoodsTypeRepository goodsTypeRepository;

    @Override
    public GoodsType save(GoodsType goodsType) {
        return goodsTypeRepository.save(goodsType);
    }

    @Override
    public List<String> findMainName() {
        return goodsTypeRepository.findMainName();
    }

    @Override
    public List<String> findChildName() {
        return goodsTypeRepository.findChildName();
    }
}
