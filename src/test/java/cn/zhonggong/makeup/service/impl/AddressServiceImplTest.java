package cn.zhonggong.makeup.service.impl;

import cn.zhonggong.makeup.domain.Address;
import cn.zhonggong.makeup.enums.ResultEnum;
import cn.zhonggong.makeup.service.AddressService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 军辉
 * 2019-07-20 10:42
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressServiceImplTest {

    @Autowired
    private AddressService addressService;

    @Test
    public void addAddress() {
        Address address = new Address(6, "中国123", "18303660000");
        Assert.assertNotNull(addressService.addAddress(address));

    }

    @Test
    public void selectByUserId() {
        Assert.assertNotEquals(addressService.selectByUserId(8), ResultEnum.RESULT_ENUM_FAIL.getCode());
    }

    @Test
    public void updateById() {
        Address address = new Address(6, "test", "123");
        address.setId(1);
        Assert.assertNotEquals(addressService.updateById(address), ResultEnum.RESULT_ENUM_FAIL.getCode());
    }

    @Test
    public void deleteById() {
        Assert.assertEquals(addressService.deleteById(1), ResultEnum.RESULT_ENUM_SUCCESS.getCode());
    }
}