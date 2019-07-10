package cn.zhonggong.makeup.domain;

import cn.zhonggong.makeup.enums.SexEnum;
import cn.zhonggong.makeup.enums.UserTypeEnum;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 军辉
 * 2019-07-10 21:04
 */
@Entity
@Data
public class User {

    @Id
    private Integer id;
    private String userAccount;
    private String userName;
    private String password;
    private Integer userType = UserTypeEnum.USER_TYPE_NORMAL.getCode();
    private String temp;

    //默认 男
    private Integer sex = SexEnum.Male.getCode();

    public User() {
    }


    public User(Integer id, String userAccount, String userName, String password, Integer userType, Integer sex) {
        this.id = id;
        this.userAccount = userAccount;
        this.userName = userName;
        this.password = password;
        this.userType = userType;
        this.sex = sex;
    }
}
