package cn.zhonggong.makeup.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * 军辉
 * 2019-07-10 21:29
 */
@Entity
@Data
public class Comment {

    @Id
    private Integer id;

    private Integer goodsId;
    private String details;
    private Integer userId;
    private String userAccount;
    private String picture;
    private Date time;
    private String temp;

    public Comment() {
    }

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
