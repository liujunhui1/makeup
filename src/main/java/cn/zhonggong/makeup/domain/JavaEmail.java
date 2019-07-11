package cn.zhonggong.makeup.domain;

import lombok.Data;

/**
 * 军辉
 * 2019-07-11 8:54
 */
@Data
public class JavaEmail {

    private String addressee;//收信人的email地址
    private String theme;//主题
    private String content;//内容

    public JavaEmail() {
    }

    public JavaEmail(String addressee, String theme, String content) {
        this.addressee = addressee;
        this.theme = theme;
        this.content = content;
    }
}
