package cn.zhonggong.makeup.repository;

import cn.zhonggong.makeup.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * 军辉
 * 2019-07-13 9:48
 * <p>
 * JpaSpecificationExecutor:实现了一些复杂的查询方法
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>, JpaSpecificationExecutor<Order> {


}
