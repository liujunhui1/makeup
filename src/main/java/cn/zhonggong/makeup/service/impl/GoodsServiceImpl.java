package cn.zhonggong.makeup.service.impl;

import cn.zhonggong.makeup.domain.Goods;
import cn.zhonggong.makeup.repository.GoodsRepository;
import cn.zhonggong.makeup.service.GoodsService;
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

import java.util.List;

/**
 * 军辉
 * 2019-07-13 15:57
 */
@Slf4j
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public List<Goods> findAllGoods() {
        return goodsRepository.findAll();

    }


    @Override
    public ResultVO save(Goods goods) {
        log.info("商品信息:" + goods);
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
            if (search.equals("")) {
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
}
