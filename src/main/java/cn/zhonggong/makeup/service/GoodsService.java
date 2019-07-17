package cn.zhonggong.makeup.service;

import cn.zhonggong.makeup.domain.Goods;
import cn.zhonggong.makeup.vo.ResultVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 军辉
 * 2019-07-13 10:15
 */
public interface GoodsService {

    List<Goods> findAllGoods();

    // List<Goods> findByMainName();

    ResultVO save(Goods goods);

    ResultVO<Object> selectGoods(int page, int limit, String search);

    ResultVO findByMainId(int mainId);

    ResultVO findByChildId(int childId);

    ResultVO findById(int id);



}
