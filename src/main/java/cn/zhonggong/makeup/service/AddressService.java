package cn.zhonggong.makeup.service;

import cn.zhonggong.makeup.domain.Address;
import cn.zhonggong.makeup.vo.ResultVO;

/**
 * 军辉
 * 2019-07-13 10:16
 */
public interface AddressService {

    ResultVO addAddress(Address address);

    ResultVO selectByUserId(int userId);

    ResultVO updateById(Address address);

    ResultVO deleteById(int id);
}
