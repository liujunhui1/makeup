package cn.zhonggong.makeup.repository;

import cn.zhonggong.makeup.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 军辉
 * 2019-07-13 9:48
 */
public interface OrderRespository extends JpaRepository<Order,Integer> {
}
