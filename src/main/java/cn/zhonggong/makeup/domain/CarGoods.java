package cn.zhonggong.makeup.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 军辉
 * 2019-07-17 15:46
 */
@Data
@Entity(name = "tb_mycar_goods")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class CarGoods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer carId;
    private Integer userId;

    @Column(name = "goods_id")
    private Integer goodsId;
    private String goodsName;
    private BigDecimal goodsPrice;
    private Integer goodsCount;

    public CarGoods(Integer carId, Integer userId, Integer goodsId, String goodsName, BigDecimal goodsPrice, Integer goodsCount) {
        this.carId = carId;
        this.userId = userId;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsCount = goodsCount;
    }
}
