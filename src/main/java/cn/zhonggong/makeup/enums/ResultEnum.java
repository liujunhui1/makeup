package cn.zhonggong.makeup.enums;

import lombok.Getter;

/**
 * 军辉
 * 2019-07-11 21:42
 */
@Getter
public enum ResultEnum implements CodeEnum {

    RESULT_ENUM_FAIL(0, "fail"),

    RESULT_ENUM_SUCCESS(1, "success");

    private Integer code;
    private String msg;

    ResultEnum() {
    }

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
