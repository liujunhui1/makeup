package cn.zhonggong.makeup;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

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

    @Test
    public void send(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sender);
        message.setTo("748936836@qq.com");
        message.setSubject("主題：你好");
        message.setText("內容:世界");
        mailSender.send(message);
    }
}
