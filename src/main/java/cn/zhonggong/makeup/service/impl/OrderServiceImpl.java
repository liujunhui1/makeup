package cn.zhonggong.makeup.service.impl;

import cn.zhonggong.makeup.domain.Order;
import cn.zhonggong.makeup.repository.OrderRepository;
import cn.zhonggong.makeup.service.OrderService;
import cn.zhonggong.makeup.util.ResultVOUtil;
import cn.zhonggong.makeup.util.SpecificationUtil;
import cn.zhonggong.makeup.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

/**
 * 军辉
 * 2019-07-15 13:53
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public ResultVO save(Order order) {
        log.info("订单信息：" + order);
        if (null == order) {
            return ResultVOUtil.Fail("所添加订单为空");
        } else {
            orderRepository.save(order);
            return ResultVOUtil.Success("订单添加成功");
        }

    }

    @Override
    public ResultVO<Object> selectOrders(int curr, int size, String search) {
        Sort sort = null;
        Pageable pageable = null;
        Page<Order> page = null;


        if (search.equals("")) {
            //根据id倒序查询
            sort = new Sort(Sort.Direction.DESC, "id");
            pageable = PageRequest.of(curr, size, sort);
            page = orderRepository.findAll(pageable);
        } else {
            String[] property = {"id"};
            Specification<Order> specification = new SpecificationUtil<Order>(search).getSpe(property, "userName", "goodsName", "childName");
            sort = new Sort(Sort.Direction.ASC, "id");
            pageable = PageRequest.of(curr, size, sort);
            page = orderRepository.findAll(specification, pageable);
        }

        if (page.getTotalElements() == 0) {
            return ResultVOUtil.Fail("订单查询为空");
        } else {
            log.info("订单信息：" + page.getContent());
            return ResultVOUtil.Success("订单查询成功", page.getTotalElements(), page.getContent());
        }

    }


}

