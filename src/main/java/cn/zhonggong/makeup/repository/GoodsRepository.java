package cn.zhonggong.makeup.repository;

import cn.zhonggong.makeup.domain.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 军辉
 * 2019-07-13 9:23
 */
@Repository
public interface GoodsRepository extends JpaRepository<Goods, Integer> {

    // List<String> ;

    //List<Goods> findByMainName();
    //String findByMainName();






}
