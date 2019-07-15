package cn.zhonggong.makeup.service.impl;

import cn.zhonggong.makeup.domain.Goods;
import cn.zhonggong.makeup.enums.ResultEnum;
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
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * 军辉
 * 2019-07-13 15:57
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public List<Goods> findAllGoods() {
        return goodsRepository.findAll();
    }


    @Override
    public Goods save(Goods goods) {
        return goodsRepository.save(goods);
    }

    @Override
    public
    ResultVO<Object> selectGoods(int curr, int size, String search) {
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
                String[] property = { "id" };
                Specification<Goods> specification = new SpecificationUtil<Goods>(search).getSpe(property, "goodsName",
                        "mainName");
                sort = new Sort(Sort.Direction.ASC, "id");
                pageable = PageRequest.of(curr, size, sort);
                page = goodsRepository.findAll(specification, pageable);
            }
            if (page.getTotalElements() == 0) {
                return ResultVOUtil.Fail("查询失败");
            }
        } catch (Exception e) {
            return ResultVOUtil.Fail("查询失败");
        }
        return ResultVOUtil.success(page.getTotalElements(), page.getContent());
    }
}
