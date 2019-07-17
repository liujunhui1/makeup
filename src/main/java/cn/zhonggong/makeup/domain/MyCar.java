package cn.zhonggong.makeup.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * 军辉
 * 2019-07-10 21:43
 */
@Data
@Entity(name = "tb_mycar")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class MyCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;

    /*    private Integer goodsId;
        private String goodsName;

        private String childName;
        private BigDecimal price;*/

/*
    @ElementCollection(targetClass = CarGoods.class)
    private List<CarGoods> carGoods;
*/

    //运费
    private BigDecimal freight;
    //总金额
    private BigDecimal totalPrice;

    private String temp;


/*    public MyCar(Integer userId, List<Goods> goods, BigDecimal freight, BigDecimal totalPrice) {
        this.userId = userId;
        this.goods = goods;
        this.freight = freight;
        this.totalPrice = totalPrice;
    }*/


    public MyCar(Integer userId, BigDecimal freight, BigDecimal totalPrice, String temp) {
        this.userId = userId;

        this.freight = freight;
        this.totalPrice = totalPrice;
        this.temp = temp;
    }
}
