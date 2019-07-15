package cn.zhonggong.makeup.util;

import cn.zhonggong.makeup.enums.ResultEnum;
import cn.zhonggong.makeup.vo.ResultVO;

/**
 * 军辉
 * 2019-07-11 21:41
 */
public class ResultVOUtil {

    public static ResultVO Success(String msg) {
        return new ResultVO(ResultEnum.RESULT_ENUM_SUCCESS.getCode(), msg);
    }

    public static ResultVO Fail(String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(ResultEnum.RESULT_ENUM_FAIL.getCode());
        resultVO.setMsg(msg);
        return resultVO;
    }

    public static ResultVO Success(String msg, Integer count, Object data) {
        return new ResultVO(ResultEnum.RESULT_ENUM_SUCCESS.getCode(), msg, count, data);
    }

    public static ResultVO Fail(String msg, Integer count, Object data) {
        return new ResultVO(ResultEnum.RESULT_ENUM_FAIL.getCode(), msg, count, data);
    }

    //分页返回数据
    public static ResultVO<Object> success(long count, Object object) {
        ResultVO<Object> result = new ResultVO<Object>();
        result.setCode(ResultEnum.RESULT_ENUM_SUCCESS.getCode());
        result.setMsg(ResultEnum.RESULT_ENUM_SUCCESS.getMsg());
        result.setCount(count);
        result.setData(object);
        return result;
    }
}
