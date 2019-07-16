package cn.zhonggong.makeup.service.impl;

import cn.zhonggong.makeup.domain.GoodsType;
import cn.zhonggong.makeup.repository.GoodsTypeRepository;
import cn.zhonggong.makeup.service.GoodsTypeService;
import cn.zhonggong.makeup.util.ResultVOUtil;
import cn.zhonggong.makeup.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 军辉
 * 2019-07-15 9:37
 */
@Slf4j
@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Autowired
    private GoodsTypeRepository goodsTypeRepository;

    @Override
    public ResultVO save(GoodsType goodsType) {
        log.info("商品类型:" + goodsType);
        if (goodsType == null) {
            return ResultVOUtil.Fail("增加商品类型失败");
        } else {
            System.out.println(goodsTypeRepository.save(goodsType));
            return ResultVOUtil.Success("增加商品类型成功");
        }

    }

    @Override
    public ResultVO findMainName() {
        List<String> mainNames = goodsTypeRepository.findMainName();
        log.info("一级导航:" + mainNames);
        if (mainNames == null || mainNames.size() == 0) {
            return ResultVOUtil.Fail("查询一级导航失败");
        } else {
            return ResultVOUtil.Success("查询一级导航成功", mainNames.size(), mainNames);

        }
    }

    @Override
    public ResultVO findChildName() {
        List<String> childNames = goodsTypeRepository.findChildName();
        log.info("二级导航：" + childNames);
        if (childNames == null || childNames.size() == 0) {
            return ResultVOUtil.Fail("查询二级导航失败");
        } else {
            return ResultVOUtil.Success("查询二级导航成功", childNames.size(), childNames);

        }
    }
}
