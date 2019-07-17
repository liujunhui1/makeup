package cn.zhonggong.makeup.repository;

import cn.zhonggong.makeup.domain.CarGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 军辉
 * 2019-07-17 16:44
 */
@Repository
public interface CarGoodsRepository extends JpaRepository<CarGoods, Integer> {
}
