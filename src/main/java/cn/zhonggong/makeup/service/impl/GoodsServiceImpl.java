package cn.zhonggong.makeup.service.impl;

import cn.zhonggong.makeup.domain.Goods;
import cn.zhonggong.makeup.repository.GoodsRepository;
import cn.zhonggong.makeup.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 军辉
 * 2019-07-13 15:57
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public List<Goods> findAllGoods() {
        return goodsRepository.findAll();
    }


    @Override
    public Goods save(Goods goods) {
        return goodsRepository.save(goods);
    }
}
