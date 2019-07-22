package cn.zhonggong.makeup.service;

import cn.zhonggong.makeup.domain.CarGoods;
import cn.zhonggong.makeup.vo.ResultVO;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 军辉
 * 2019-07-19 19:22
 */
public interface CarGoodsService {

    //增加商品到购物车
    ResultVO addCarGoods(CarGoods carGoods);

    ResultVO selectCarGoodsByGoodsId(int goodsId);

    ResultVO deleteCarGoodsByGoodsId(int goodsId);

    ResultVO selectCarGoodsByUserId(int userId);

    ResultVO deleteCarGoodsById(int id);
}
