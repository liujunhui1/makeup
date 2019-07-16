package cn.zhonggong.makeup.service;

import cn.zhonggong.makeup.domain.GoodsType;
import cn.zhonggong.makeup.vo.ResultVO;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 军辉
 * 2019-07-13 10:17
 */
public interface GoodsTypeService {

    // post /goodstype/addgoodstype
    ResultVO save(GoodsType goodsType);

    List<GoodsType> findMainName();

    // get /goodstype/getchildname
    ResultVO findChildName();

    ResultVO findChildNameByMainId(int mainId);

    List<String> findChildNameByMainName(String mainName);

    ResultVO getNavigation();


}
