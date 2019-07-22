package cn.zhonggong.makeup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class MakeupApplication {

    public static void main(String[] args) {
        SpringApplication.run(MakeupApplication.class, args);
    }

}
