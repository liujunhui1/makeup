package cn.zhonggong.makeup.vo;

import cn.zhonggong.makeup.domain.CarGoods;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * 军辉
 * 2019-07-17 16:59
 */
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class CarVO<T> {

    private Integer userId;
    private BigDecimal freight;
    private BigDecimal price;
    private T carGoods;


    public CarVO(Integer userId, BigDecimal freight, BigDecimal price, T carGoods) {
        this.userId = userId;
        this.freight = freight;
        this.price = price;
        this.carGoods = carGoods;
    }
}
