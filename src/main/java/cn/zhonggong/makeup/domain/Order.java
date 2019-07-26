package cn.zhonggong.makeup.domain;

import cn.zhonggong.makeup.enums.OrderEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

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
@NoArgsConstructor(access = AccessLevel.PUBLIC)
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
    private Integer count = 1;
    private Integer carGoodsId;
    private BigDecimal price;
    private Integer status = OrderEnum.ORDER_ENUM_UNPAID.getCode();

    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date time;//上架时间

    public Order(Integer userId, String userName, Integer goodsId, String goodsName, Integer childId, String childName, Integer count, BigDecimal price, Integer status) {
        this.userId = userId;
        this.userName = userName;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.childId = childId;
        this.childName = childName;
        this.count = count;
        this.price = price;
        this.status = status;
    }


}
