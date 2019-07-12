package cn.zhonggong.makeup.vo;

import lombok.Data;

/**
 * 军辉
 * 2019-07-11 21:37
 * 返回前台的json数据
 */
@Data
public class ResultVO<T> {

    private Integer code;
    private String msg;
    private Integer count;
    private T data;

    public ResultVO() {
    }


    public ResultVO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultVO(Integer code, String msg, Integer count, T data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }
}
