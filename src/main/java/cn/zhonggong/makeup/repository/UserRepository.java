package cn.zhonggong.makeup.repository;

import cn.zhonggong.makeup.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 军辉
 * 2019-07-11 20:23
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserByUserName(String userName);
}
