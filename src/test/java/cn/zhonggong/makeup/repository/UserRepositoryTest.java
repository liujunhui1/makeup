package cn.zhonggong.makeup.repository;

import cn.zhonggong.makeup.domain.User;
import cn.zhonggong.makeup.service.UserService;
import cn.zhonggong.makeup.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 军辉
 * 2019-07-11 20:28
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testAdd() {
        User user = new User("123@qq.com", "root", "root", 1, 1);


        Assert.assertNotNull(userService.registerUser(user));
    }

    @Test
    public void testFindByName() {
        Assert.assertNotNull(userService.findByAccount("123@qq.com"));
    }

    @Test
    public void findByUserAccount() {
        User user = userRepository.findByUserAccount("test@qq.com");
        log.info("user:" + user);
        Assert.assertNotNull(user);
    }
}