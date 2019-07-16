package cn.zhonggong.makeup.controller;

import cn.zhonggong.makeup.domain.GoodsType;
import cn.zhonggong.makeup.service.impl.GoodsTypeServiceImpl;
import cn.zhonggong.makeup.util.ResultVOUtil;
import cn.zhonggong.makeup.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 军辉
 * 2019-07-15 11:22
 */
@RestController
@RequestMapping("/goodstype")
public class GoodsTypeController {


    @Autowired
    private GoodsTypeServiceImpl goodsTypeService;

    @GetMapping("/getmainname")
    public List<GoodsType> getMainName() {
        List<GoodsType> mainNameList = goodsTypeService.findMainName();
        return mainNameList;
//        if (null == mainNameList || mainNameList.size() == 0) {
//            return ResultVOUtil.Fail("查询一级导航栏为空");
//        } else {
//            return ResultVOUtil.Success("查询一级导航栏成功", mainNameList.size(), mainNameList);
//        }
    }

    @GetMapping("/getchildname")
    public ResultVO getChildName() {
        List<String> childNameList = goodsTypeService.findChildName();
        if (null == childNameList || childNameList.size() == 0) {
            return ResultVOUtil.Fail("查询二级导航栏为空");
        } else {
            return ResultVOUtil.Success("查询二级导航栏成功", childNameList.size(), childNameList);
        }
    }
}
