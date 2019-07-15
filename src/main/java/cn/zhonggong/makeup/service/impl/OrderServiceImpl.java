package cn.zhonggong.makeup.service.impl;

import cn.zhonggong.makeup.domain.Order;
import cn.zhonggong.makeup.repository.OrderRepository;
import cn.zhonggong.makeup.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 军辉
 * 2019-07-15 13:53
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }
}
