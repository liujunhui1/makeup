package cn.zhonggong.makeup.repository;

import cn.zhonggong.makeup.domain.CarGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 军辉
 * 2019-07-17 16:44
 */
@Repository
public interface CarGoodsRepository extends JpaRepository<CarGoods, Integer> {

    CarGoods findByGoodsId(int goodsId);

    @Modifying
    @Transactional
    @Query(value = "delete from tb_mycar_goods where goods_id = ?", nativeQuery = true)
    int deleteByGoodsId(int goodsId);

    List<CarGoods> findByUserId(int userId);
}
