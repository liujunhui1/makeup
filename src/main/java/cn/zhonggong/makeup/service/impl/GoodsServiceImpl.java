package cn.zhonggong.makeup.service.impl;

import cn.zhonggong.makeup.domain.Goods;
import cn.zhonggong.makeup.repository.GoodsRepository;
import cn.zhonggong.makeup.service.GoodsService;
import cn.zhonggong.makeup.util.ResultVOUtil;
import cn.zhonggong.makeup.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

/**
 * 军辉
 * 2019-07-13 15:57
 */
@Slf4j
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
