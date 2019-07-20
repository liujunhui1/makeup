package cn.zhonggong.makeup.service.impl;

import cn.zhonggong.makeup.domain.User;
import cn.zhonggong.makeup.enums.SexEnum;
import cn.zhonggong.makeup.enums.UserTypeEnum;
import cn.zhonggong.makeup.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 军辉
 * 2019-07-18 14:10
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @Autowired
    private UserService userService;


    @Test
    public void updateUser() {

        User user = (User) userService.findByAccount("root").getData();
        //user.setId(10);
        //  user.setUserAccount("account");
        System.out.println(user);
       // user.setUserName("修改测试123123123213");
        user.setPassword("pass");
        user.setSex(SexEnum.Female.getCode());
        user.setUserType(UserTypeEnum.USER_TYPE_ADMIN.getCode());

        log.info(userService.updateUser(user) + "");
    }
}