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

    /*  User findUserByUserAccount(String userAccount);*/

    User findByUserAccount(String userAccount);


    void deleteById(int id);


    /*
    用户账户（邮箱）禁止修改
    update tb_user set user_name = 'test',password = 'test_password' where id = 10;
     */
/*    @Modifying
    @Query("update User set userName = ? where userId=?")
    User updateUser(@Param("userName") String userName, @Param("userId") Integer userId);*/
}
