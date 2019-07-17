package cn.zhonggong.makeup.repository;

import cn.zhonggong.makeup.domain.MyCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 军辉
 * 2019-07-13 9:47
 */
@Repository
public interface MyCarRepository extends JpaRepository<MyCar, Integer> {

   /* @Query(value = " insert into tb_mycar (userId,goods,freight,totalPrice) values (?,?,?,?)", nativeQuery = true)
    MyCar add(MyCar myCar);*/
}
