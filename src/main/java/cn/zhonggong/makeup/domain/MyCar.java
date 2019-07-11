package cn.zhonggong.makeup.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 军辉
 * 2019-07-10 21:43
 */
@Entity
@Data
public class MyCar {

    @Id
    private Integer id;

    private Integer userId;
    private Integer goodsId;
    private String goodsName;
    private String childName;
    private BigDecimal price;
    private BigDecimal freight;//运费
    private BigDecimal totalPrice;//总金额
    private String temp;

    public MyCar() {
    }

    public MyCar(Integer id, Integer userId, Integer goodsId, String goodsName, String childName, BigDecimal price, BigDecimal freight, BigDecimal totalPrice, String temp) {
        this.id = id;
        this.userId = userId;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.childName = childName;
        this.price = price;
        this.freight = freight;
        this.totalPrice = totalPrice;
        this.temp = temp;
    }
}
