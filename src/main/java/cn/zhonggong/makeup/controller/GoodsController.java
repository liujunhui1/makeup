package cn.zhonggong.makeup.controller;

import cn.zhonggong.makeup.domain.Goods;
import cn.zhonggong.makeup.service.GoodsService;
import cn.zhonggong.makeup.util.UploadUtil;
import cn.zhonggong.makeup.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * 军辉
 * 2019-07-13 15:51
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {


    @Autowired
    private GoodsService goodsService;


    @GetMapping("/toselectgoods")
    public ModelAndView toUser(Model model) {
        return new ModelAndView("/part/goods");
    }

    @GetMapping("/toupdategoods")
    public ModelAndView updatePage() {
        return new ModelAndView("/part/updategoods");
    }

    @GetMapping("/toaddgoods")
    public ModelAndView addPage() {
        return new ModelAndView("/part/addGoods");
    }

    @GetMapping("/getgoods")
    public ResultVO<Object> selectGoods(@RequestParam(defaultValue = "1", name = "page") int page,
                                        @RequestParam(defaultValue = "10", name = "limit") int limit,
                                        @RequestParam(defaultValue = "", name = "search") String search) {
        return goodsService.selectGoods(page - 1, limit, search);
    }

    @PostMapping("/addgoods")
    public ResultVO addgoods(Goods goods) {
        return goodsService.save(goods);
    }

    @GetMapping("/getbymainid")
    public ResultVO findByMainId(@RequestParam(value = "mainId", required = true, defaultValue = "1") int mainId) {
        return goodsService.findByMainId(mainId);
    }

    @GetMapping("/getbychildid")
    public ResultVO findByChildId(@RequestParam(value = "childId", required = true, defaultValue = "1") int childId) {
        return goodsService.findByChildId(childId);
    }

    @GetMapping("/getbyid")
    public ResultVO findById(@RequestParam(value = "id", required = true) int id) {
        return goodsService.findById(id);
    }

    @PostMapping("/uploadpic")
    public ResultVO uploadPic(@RequestParam("file") MultipartFile file) {
        return UploadUtil.uploadPic(file);
    }

    @GetMapping("/getbymainname")
    public ResultVO findByMainName(@RequestParam(value = "mainname", defaultValue = "1", required = true) String mainName) {
        return goodsService.findByMainName(mainName);
    }

    @GetMapping("/getbychildname")
    public ResultVO findByChildName(@RequestParam(value = "childname", defaultValue = "1", required = true) String childName) {
        return goodsService.findByChildName(childName);
    }

    @DeleteMapping("/deletebyid")
    public ResultVO deleteById(@RequestParam(value = "id", required = true) int id) {
        return goodsService.deleteById(id);
    }

    @PutMapping("/updategoods")
    public ResultVO updateGoods(Goods goods) {
        return goodsService.updateGoods(goods);

    }


}
