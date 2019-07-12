package cn.zhonggong.makeup.domain;

import cn.zhonggong.makeup.enums.OrderEnum;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 军辉
 * 2019-07-10 21:45
 */
@Data
@Entity(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;
    private String userName;
    private Integer goodsId;
    private String goodsName;
    private Integer childId;
    private String childName;
    private Integer count;
    private BigDecimal price;
    private Integer status = OrderEnum.ORDER_ENUM_UNPAID.getCode();
    private Date time;//上架时间


}
