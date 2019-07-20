package cn.zhonggong.makeup.controller;

import cn.zhonggong.makeup.domain.Address;
import cn.zhonggong.makeup.service.AddressService;
import cn.zhonggong.makeup.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 军辉
 * 2019-07-20 14:21
 */
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/addaddress")
    public ResultVO addAddress(Address address) {
        System.out.println("conteoller:" + address);
        return addressService.addAddress(address);
    }

    @GetMapping("/findbyuserid")
    public ResultVO selectByUserId(@RequestParam(name = "userId", required = true) int userId) {
        return addressService.selectByUserId(userId);
    }

    @PutMapping("/updatebyid")
    public ResultVO updateById(Address address) {
        return updateById(address);
    }

    @DeleteMapping("/deletebyid")
    public ResultVO deleteById(@RequestParam(name = "id", required = true) int id) {
        return addressService.deleteById(id);
    }
}
