package cn.zhonggong.makeup.enums;

import lombok.Getter;

/**
 * 军辉
 * 2019-07-10 21:50
 */
@Getter
public enum OrderEnum implements CodeEnum {

    ORDER_ENUM_UNPAID(0,"未支付"),
    ORDER_ENUM_PAID(1,"已支付"),
    ORDER_ENUM_CANCEL(2,"订单已取消");




    private Integer code;
    private String msg;

    OrderEnum() {
    }

    OrderEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
