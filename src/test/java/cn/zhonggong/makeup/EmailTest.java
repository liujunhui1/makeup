package cn.zhonggong.makeup;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 军辉
 * 2019-07-10 20:45
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class EmailTest {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String sender;

    private String addressee = "1365413148@qq.com";

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @Test
    public void send() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sender);
        message.setTo(addressee);
        message.setSubject("主題：你好");
        String checkCode = verificationCode();
        System.out.println(checkCode);
        message.setText("內容:世界 " + checkCode);
        mailSender.send(message);

        redisTemplate.opsForValue().set(addressee, checkCode, 1000 * 60 * 10, TimeUnit.MILLISECONDS);

        System.out.println(redisTemplate.opsForValue().get(addressee));

    }

    /*
    生成验证码
     */
    public static String verificationCode() {
        return String.valueOf(new Random().nextInt(899999) + 100000);
    }


    @Test
    public void testRandom() {
        for (int i = 0; i < 10; i++) {
            System.out.println(verificationCode());
        }
    }
}
