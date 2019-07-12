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

    ResultVO save(User user);

    User findByName(String userName);

    User findByAccount(String userAccount);

    ResultVO login(User user);

}
