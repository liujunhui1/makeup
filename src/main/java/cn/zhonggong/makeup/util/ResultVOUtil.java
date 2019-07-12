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

    public static ResultVO Success(String msg, Integer code, Object data) {
        return new ResultVO(ResultEnum.RESULT_ENUM_SUCCESS.getCode(), msg, code, data);
    }

    public static ResultVO Fail(String msg, Integer code, Object data) {
        return new ResultVO(ResultEnum.RESULT_ENUM_FAIL.getCode(), msg, code, data);
    }
}
