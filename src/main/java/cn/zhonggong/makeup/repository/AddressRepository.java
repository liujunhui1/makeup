package cn.zhonggong.makeup.repository;

import cn.zhonggong.makeup.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 军辉
 * 2019-07-13 9:20
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    List<Address> findByUserId(int userId);
}
