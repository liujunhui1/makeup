package cn.zhonggong.makeup.service;

import cn.zhonggong.makeup.domain.MyCar;
import cn.zhonggong.makeup.vo.ResultVO;

/**
 * 军辉
 * 2019-07-13 10:17
 */
public interface MyCarService {

    ResultVO<MyCar> add(MyCar myCar);
}
