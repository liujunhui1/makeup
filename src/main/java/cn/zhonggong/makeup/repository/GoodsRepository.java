package cn.zhonggong.makeup.repository;

import cn.zhonggong.makeup.domain.Goods;
import cn.zhonggong.makeup.vo.ResultVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * 军辉
 * 2019-07-13 9:23
 */
@Repository
public interface GoodsRepository extends JpaRepository<Goods, Integer>, JpaSpecificationExecutor<Goods> {

    // List<String> ;

    //List<Goods> findByMainName();
    //String findByMainName();






}
