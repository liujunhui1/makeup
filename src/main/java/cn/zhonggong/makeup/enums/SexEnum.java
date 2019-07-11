package cn.zhonggong.makeup.enums;

import lombok.Getter;

/**
 * 军辉
 * 2019-07-10 21:18
 */
@Getter
public enum SexEnum implements CodeEnum {

    Male(0, "男"),
    Female(1, "女");

    private Integer code;
    private String msg;

    SexEnum() {
    }

    SexEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
