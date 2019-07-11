package cn.zhonggong.makeup.enums;

import lombok.Getter;

/**
 * 军辉
 * 2019-07-10 21:56
 */
@Getter
public enum  UserTypeEnum  implements CodeEnum{

    USER_TYPE_ADMIN(0,"管理员"),
    USER_TYPE_NORMAL(1,"普通用戶");


    private Integer code;
    private String msg;

     UserTypeEnum() {
    }

     UserTypeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
