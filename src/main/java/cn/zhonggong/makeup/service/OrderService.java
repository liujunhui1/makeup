package cn.zhonggong.makeup.service;

import cn.zhonggong.makeup.domain.Order;
import cn.zhonggong.makeup.vo.ResultVO;

/**
 * 军辉
 * 2019-07-13 10:17
 */
public interface OrderService {

    ResultVO save(Order order);

    ResultVO<Object> selectOrders(int page, int limit, String search);
}
