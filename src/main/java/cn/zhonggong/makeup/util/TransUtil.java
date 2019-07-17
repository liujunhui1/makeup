package cn.zhonggong.makeup.util;

import cn.zhonggong.makeup.domain.CarGoods;
import cn.zhonggong.makeup.domain.Goods;

/**
 * 军辉
 * 2019-07-17 16:02
 */
public class TransUtil {

    public static CarGoods goods2CarGoods(Goods goods) {
        CarGoods carGoods = new CarGoods();
        carGoods.setGoodsId(goods.getId());
        carGoods.setGoodsName(goods.getGoodsName());
        carGoods.setGoodsPrice(goods.getPrice());
        return carGoods;
    }
}
