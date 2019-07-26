package cn.zhonggong.makeup.service;

import cn.zhonggong.makeup.domain.User;
import cn.zhonggong.makeup.enums.UserTypeEnum;
import cn.zhonggong.makeup.vo.ResultVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * 军辉
 * 2019-07-11 20:18
 */

public interface UserService {

    ResultVO registerUser(User user);

    User findByName(String userName);

    ResultVO findByAccount(String userAccount);

    ResultVO login(User user);

    /*
    userAccount 禁止修改
     */
    ResultVO updateUser(User user);

    ResultVO findAll();

    ResultVO deleteById(int id);

    ResultVO adminLogin(User user);

}
