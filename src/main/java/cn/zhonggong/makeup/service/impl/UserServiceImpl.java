package cn.zhonggong.makeup.service.impl;

import cn.zhonggong.makeup.domain.User;
import cn.zhonggong.makeup.repository.UserRepository;
import cn.zhonggong.makeup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 军辉
 * 2019-07-11 20:30
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByName(String userName) {
        return userRepository.findUserByUserName(userName);
    }
}
