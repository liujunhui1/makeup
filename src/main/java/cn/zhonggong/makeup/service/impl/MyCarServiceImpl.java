package cn.zhonggong.makeup.service.impl;

import cn.zhonggong.makeup.domain.MyCar;
import cn.zhonggong.makeup.repository.MyCarRepository;
import cn.zhonggong.makeup.service.MyCarService;
import cn.zhonggong.makeup.util.ResultVOUtil;
import cn.zhonggong.makeup.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 军辉
 * 2019-07-17 10:23
 */
@Slf4j
@Service
public class MyCarServiceImpl implements MyCarService {

    @Autowired
    private MyCarRepository carRepository;

    @Override
    public ResultVO<MyCar> add(MyCar myCar) {
        //TODO
        //购物车与用户是一一对应的，需要判断购物车id与用户id是否一样
        log.info("购物车信息：" + myCar);
        if (myCar == null || "".equals(myCar)) {
            return ResultVOUtil.Fail("购物车为空");
        } else {
            System.out.println("++++++++++++++++++++++++++++++++++++");
            carRepository.save(myCar);
            System.out.println("-------------------------------------");
            return ResultVOUtil.Success("购物车添加成功", 0, myCar);
        }

    }

    @Override
    public ResultVO selectMyCayByUserId(int UserId) {
        return null;
    }
}
