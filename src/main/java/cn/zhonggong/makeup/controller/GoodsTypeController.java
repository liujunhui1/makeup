package cn.zhonggong.makeup.controller;

import cn.zhonggong.makeup.domain.GoodsType;
import cn.zhonggong.makeup.service.GoodsService;
import cn.zhonggong.makeup.service.impl.GoodsTypeServiceImpl;
import cn.zhonggong.makeup.util.ResultVOUtil;
import cn.zhonggong.makeup.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
        return goodsTypeService.findMainName();
    }

    @GetMapping("/getchildname")
    public ResultVO getChildName() {
        return goodsTypeService.findChildName();
    }

    @PostMapping("/addgoodstype")
    public ResultVO addgoodstype(GoodsType goodsType) {
        return goodsTypeService.save(goodsType);
    }

    @GetMapping("/getnav")
    public ResultVO getnav() {
        return goodsTypeService.getNavigation();
    }

    @GetMapping("/childname")
    public List<GoodsType> childName(int mainId) {
        return goodsTypeService.getchildName(mainId);
    }

}
