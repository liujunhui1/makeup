package cn.zhonggong.makeup.service.impl;

import cn.zhonggong.makeup.domain.User;
import cn.zhonggong.makeup.repository.UserRepository;
import cn.zhonggong.makeup.service.UserService;
import cn.zhonggong.makeup.util.ResultVOUtil;
import cn.zhonggong.makeup.vo.ResultVO;
import jdk.nashorn.internal.runtime.options.Option;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 军辉
 * 2019-07-11 20:30
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpSession httpSession;


    /*
    调用注册方法之前必须调用 findByAccount() 账户是否存在
     */
    @Override
    public ResultVO registerUser(User user) {
        if (null == user || "".equals(user)) {
            return ResultVOUtil.Fail("当前用户信息为空");
        }
        if (userRepository.findByUserAccount(user.getUserAccount()) != null) {
            log.info(user.toString());
            return ResultVOUtil.Fail("注册失败，账号已存在");
        } else {
            log.info(user.toString());
            userRepository.save(user);
            return ResultVOUtil.Success("用户注册或修改信息成功");
        }

    }

    @Override
    public ResultVO login(User user) {
        if (null == user || "".equals(user)) {
            return ResultVOUtil.Fail("账户信息为空");
        }
        User dbUser = userRepository.findByUserAccount(user.getUserAccount());

        if (null == user) {
            return ResultVOUtil.Fail("查无此人，请先注册");
        } else if (!user.getPassword().equals(dbUser.getPassword())) {
            log.info("用户输入用户数据的:" + user);
            log.info("数据库中的用户数据:" + dbUser);
            return ResultVOUtil.Fail("密码错误");
        } else {
            log.info("用户输入用户数据的:" + user);
            log.info("数据库中的用户数据:" + dbUser);
            httpSession.setAttribute("user", dbUser);
            return ResultVOUtil.Success("登录成功");
        }


    }

    @Override
    public User findByName(String userName) {
        return userRepository.findUserByUserName(userName);
    }

    @Override
    public ResultVO findByAccount(String userAccount) {
        log.info("userAccount:" + userAccount);
        User user = null;
        if (null == userAccount || "".equals(userAccount)) {
            return ResultVOUtil.Fail("账户信息为空");
        }
        user = userRepository.findByUserAccount(userAccount);
        log.info("user:" + user);
        if (null == user || "".equals(user)) {
            return ResultVOUtil.Fail("账户不存在");
        } else {
            return ResultVOUtil.Success("账户信息查询成功", 1, user);
        }


    }

    @Override
    public ResultVO updateUser(User updateUser) {
        log.info("修改用户的信息：" + updateUser);
        User dbUser = userRepository.findByUserAccount(updateUser.getUserAccount());
        if (dbUser == null || "".equals(dbUser)) {
            return ResultVOUtil.Fail("将要修改的账户不存在");
        } else {
            User user = userRepository.save(updateUser);
            return ResultVOUtil.Success("修改用户信息成功", 1, user);
        }

    }

    @Override
    public ResultVO findAll() {
        List<User> users = userRepository.findAll();
        log.info("users:" + users);
        if (users.size() == 0) {
            return ResultVOUtil.Fail("当前用户数据为空");
        } else {
            return ResultVOUtil.Success("查询用户数据成功", users.size(), users);
        }
    }
}
