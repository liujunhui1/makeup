package cn.zhonggong.makeup.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 军辉
 * 2019-07-10 21:31
 */
@Data
@Entity(name = "tb_goods")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String goodsName;
    private String picture;
    private Integer mainId;
    private String mainName;
    private Integer childId;
    private String childName;
    private BigDecimal price;
    private Integer count;
    private BigDecimal freight;//运费
    private String goodsDescribe;//描述
    private String temp;


    public Goods(String goodsName, String picture, Integer mainId, String mainName, Integer childId, String childName, BigDecimal price, Integer count, BigDecimal freight, String goodsDescribe) {
        this.goodsName = goodsName;
        this.picture = picture;
        this.mainId = mainId;
        this.mainName = mainName;
        this.childId = childId;
        this.childName = childName;
        this.price = price;
        this.count = count;
        this.freight = freight;
        this.goodsDescribe = goodsDescribe;
    }


}
