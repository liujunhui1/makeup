package cn.zhonggong.makeup.service;

import cn.zhonggong.makeup.domain.GoodsType;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 军辉
 * 2019-07-13 10:17
 */
public interface GoodsTypeService {

    GoodsType save(GoodsType goodsType);

    List<GoodsType> findMainName();

    List<String> findChildName();

}
