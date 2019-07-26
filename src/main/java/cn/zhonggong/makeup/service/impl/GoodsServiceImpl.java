package cn.zhonggong.makeup.service.impl;

import cn.zhonggong.makeup.domain.Goods;
import cn.zhonggong.makeup.repository.GoodsRepository;
import cn.zhonggong.makeup.service.GoodsService;
import cn.zhonggong.makeup.service.GoodsTypeService;
import cn.zhonggong.makeup.util.ResultVOUtil;
import cn.zhonggong.makeup.util.SpecificationUtil;
import cn.zhonggong.makeup.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

/**
 * 军辉
 * 2019-07-13 15:57
 */
@Slf4j
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private GoodsTypeService typeService;

    @Override
    public List<Goods> findAllGoods() {
        return goodsRepository.findAll();

    }


    @Override
    public ResultVO save(Goods goods) {
        log.info("商品信息:" + goods);
        goods.setChildName(typeService.findChildNameByChildId(goods.getChildId()));
        goods.setMainName(typeService.findMainNameByChildId(goods.getChildId()));
        if (goods == null) {
            return ResultVOUtil.Fail("商品为空");
        } else {
            goodsRepository.save(goods);
            return ResultVOUtil.Success("商品添加成功");
        }
    }

    @Override
    public ResultVO<Object> selectGoods(int curr, int size, String search) {
        Sort sort = null;
        Pageable pageable = null;
        Page<Goods> page = null;
        try {
            // 查询所有 倒序
            if ("".equals(search)) {
                sort = new Sort(Sort.Direction.DESC, "id");
                pageable = PageRequest.of(curr, size, sort);
                page = goodsRepository.findAll(pageable);
            } else {// 条件查询 正序
                String[] property = {"id"};
                Specification<Goods> specification = new SpecificationUtil<Goods>(search).getSpe(property, "goodsName",
                        "mainName");
                sort = new Sort(Sort.Direction.ASC, "id");
                pageable = PageRequest.of(curr, size, sort);

                // 根据条件分页查询数据
                page = goodsRepository.findAll(specification, pageable);
            }
            if (page.getTotalElements() == 0) {
                return ResultVOUtil.Fail("查询失败");
            }
        } catch (Exception e) {
            return ResultVOUtil.Fail("查询失败");
        }
        log.info("商品信息：" + page.getContent());
        return ResultVOUtil.Success("商品查询成功", page.getTotalElements(), page.getContent());
    }

    @Override
    public ResultVO findByMainId(int mainId) {
        List<Goods> goodsList = goodsRepository.findGoodsByMainId(mainId);
        log.info("根据一级id" + mainId + "查询商品:" + goodsList);
        if (goodsList == null || goodsList.size() == 0) {
            goodsList = goodsRepository.findAll();
            //return ResultVOUtil.Fail("根据一级id查询商品失败");
            log.info("根据一级id" + mainId + "查询商品无果，因此返回所有商品信息:" + goodsList);
            return ResultVOUtil.Success("mianId查询无果，返回所有商品信息", goodsList.size(), goodsList);
        } else {

            return ResultVOUtil.Success("根据一级id查询商品成功", goodsList.size(), goodsList);

        }

    }

    @Override
    public ResultVO findByChildId(int childId) {
        List<Goods> goodsList = goodsRepository.findGoodsByChildId(childId);
        log.info("根据二级id" + childId + "查询商品:" + goodsList);
        if (goodsList == null || goodsList.size() == 0) {
            goodsList = goodsRepository.findAll();
            // return ResultVOUtil.Fail("根据二级id查询商品失败");
            log.info("根据二级id" + childId + "查询商品无果，因此返回所有商品信息:" + goodsList);
            return ResultVOUtil.Success("childId查询无果，返回所有商品信息", goodsList.size(), goodsList);
        } else {
            return ResultVOUtil.Success("根据二级id查询商品成功", goodsList.size(), goodsList);

        }
    }

    @Override
    public ResultVO findById(int id) {
        if (id <= 0) {
            return ResultVOUtil.Fail("失败");
        } else {
            Goods goods = goodsRepository.findById(id);
            return ResultVOUtil.Success("查询成功", 1, goods);
        }
    }

    @Override
    public ResultVO findByMainName(String mainName) {
        if ("".equals(mainName) || null == mainName) {
            return ResultVOUtil.Fail("mainName为空");
        } else {
            List<Goods> goodsList = goodsRepository.findGoodsByMainName(mainName);
            log.info("goodsList:" + goodsList);
            if (goodsList.size() == 0) {
                return ResultVOUtil.Fail("所查数据为空");
            } else {
                return ResultVOUtil.Success("根据一级名称查询成功", goodsList.size(), goodsList);
            }
        }
    }

    @Override
    public ResultVO findByChildName(String childName) {
        if ("".equals(childName) || null == childName) {
            return ResultVOUtil.Fail("childName为空");
        } else {
            List<Goods> goodsList = goodsRepository.findGoodsByChildName(childName);
            if (goodsList.size() == 0) {
                return ResultVOUtil.Fail("所查数据为空");
            } else {
                return ResultVOUtil.Success("根据二级名称查询成功", goodsList.size(), goodsList);
            }
        }
    }


    @Override
    public ResultVO deleteById(int id) {
        if (id <= 0) {
            return ResultVOUtil.Fail("id <= 0,请输入一个合法的id值");
        } else {
            Goods goods = goodsRepository.findById(id);
            goodsRepository.deleteById(id);
            return ResultVOUtil.Success(id + "号商品，" + goods.getGoodsName() + " 删除成功", 1, id);
        }
    }


    @Override
    public ResultVO updateGoods(Goods updateGoods) {
        //Goods dbGood = goodsRepository.findById(updateGoods.getId()).get();
        if (updateGoods == null) {
            return ResultVOUtil.Fail("修改商品信息为空");
        } else {

            goodsRepository.save(updateGoods);
            return ResultVOUtil.Success("修改成功", 1, updateGoods);
        }
    }
}
