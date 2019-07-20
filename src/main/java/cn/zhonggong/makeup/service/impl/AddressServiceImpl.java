package cn.zhonggong.makeup.service.impl;

import cn.zhonggong.makeup.domain.Address;
import cn.zhonggong.makeup.repository.AddressRepository;
import cn.zhonggong.makeup.service.AddressService;
import cn.zhonggong.makeup.util.ResultVOUtil;
import cn.zhonggong.makeup.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 军辉
 * 2019-07-20 9:39
 */
@Slf4j
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;


    @Override
    public ResultVO addAddress(Address address) {
        log.info("新增的地址：" + address);
        if (address == null || "".equals(address)) {
            return ResultVOUtil.Fail("地址为空");
        } else {

            if (addressRepository.save(address) == null) {
                return ResultVOUtil.Fail("添加地址失败，原因看日志");
            } else {
                return ResultVOUtil.Success("添加地址成功", 1, address);
            }

        }
    }

    @Override
    public ResultVO selectByUserId(int userId) {
        if (userId <= 0) {
            return ResultVOUtil.Fail("检查userId的合法性");
        } else {
            List<Address> addressList = addressRepository.findByUserId(userId);
            if (addressList.size() == 0) {
                return ResultVOUtil.Fail("当前地址为空，请先添加地址");
            } else {
                log.info(userId + "的地址:" + addressList);
                return ResultVOUtil.Success("查询地址成功", addressList.size(), addressList);

            }
        }
    }

    @Override
    public ResultVO updateById(Address updateAddress) {

        if (updateAddress == null || "".equals(updateAddress)) {
            return ResultVOUtil.Fail("地址为空");
        } else {
            Address dbAddress = addressRepository.getOne(updateAddress.getId());
            if (dbAddress == null || "".equals(dbAddress)) {
                return ResultVOUtil.Fail("将要修改的地址不存在");
            } else {
                addressRepository.save(updateAddress);
                return ResultVOUtil.Success("修改成功", 1, updateAddress);
            }
        }

    }

    @Override
    public ResultVO deleteById(int id) {

        if (id <= 0) {
            return ResultVOUtil.Fail("检查 id 的合法性");
        } else {
            addressRepository.deleteById(id);
            return ResultVOUtil.Success(id + " 号地址已被删除");
        }

    }
}
