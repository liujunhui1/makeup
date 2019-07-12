package cn.zhonggong.makeup.service.impl;

import cn.zhonggong.makeup.domain.User;
import cn.zhonggong.makeup.repository.UserRepository;
import cn.zhonggong.makeup.service.UserService;
import cn.zhonggong.makeup.util.ResultVOUtil;
import cn.zhonggong.makeup.vo.ResultVO;
import jdk.nashorn.internal.runtime.options.Option;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 军辉
 * 2019-07-11 20:30
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public ResultVO save(User user) {
        if (null == user || "".equals(user)) {
            return ResultVOUtil.Fail("当前用户信息为空");
        }
        if (userRepository.findUserByUserAccount(user.getUserAccount()) != null) {
            log.info(user.toString());
            return ResultVOUtil.Fail("注册失败，账号已存在");
        } else {
            log.info(user.toString());
            userRepository.save(user);
            return ResultVOUtil.Success("用户注册成功");
        }

    }

    @Override
    public ResultVO login(User user) {
        if (null == user || "".equals(user)) {
            return ResultVOUtil.Fail("账户信息为空");
        }
        log.info("用户输入的user：" + user);
        User dbUser = userRepository.findUserByUserAccount(user.getUserAccount());

        if (null == user) {
            return ResultVOUtil.Fail("查无此人，请先注册");
        } else if (!user.getPassword().equals(dbUser.getPassword())) {
            log.info("用户输入用户数据的:" + user);
            log.info("数据库中的用户数据:" + dbUser);
            return ResultVOUtil.Fail("密码错误");
        } else {
            log.info("用户输入用户数据的:" + user);
            log.info("数据库中的用户数据:" + dbUser);

            return ResultVOUtil.Success("登录成功");
        }


    }

    @Override
    public User findByName(String userName) {
        return userRepository.findUserByUserName(userName);
    }

    @Override
    public User findByAccount(String userAccount) {

        return userRepository.findUserByUserAccount(userAccount);
    }
}
