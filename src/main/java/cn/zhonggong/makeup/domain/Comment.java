package cn.zhonggong.makeup.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 军辉
 * 2019-07-10 21:29
 */
@Data
@Entity(name = "tb_comment")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer goodsId;
    private String details;
    private Integer userId;
    private String userAccount;
    private String picture;

    @CreatedDate
    private Date time;
    private String temp;


    public Comment(Integer id, Integer goodsId, String details, Integer userId, String userAccount, String picture, Date time, String temp) {
        this.id = id;
        this.goodsId = goodsId;
        this.details = details;
        this.userId = userId;
        this.userAccount = userAccount;
        this.picture = picture;
        this.time = time;
        this.temp = temp;
    }
}
