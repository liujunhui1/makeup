package cn.zhonggong.makeup.service;

import cn.zhonggong.makeup.domain.Goods;
import cn.zhonggong.makeup.vo.ResultVO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 军辉
 * 2019-07-13 10:15
 */
public interface GoodsService {

    List<Goods> findAllGoods();

    // List<Goods> findByMainName();

    Goods save(Goods goods);


}
