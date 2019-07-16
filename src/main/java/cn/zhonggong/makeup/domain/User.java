package cn.zhonggong.makeup.domain;

import cn.zhonggong.makeup.enums.SexEnum;
import cn.zhonggong.makeup.enums.UserTypeEnum;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 军辉
 * 2019-07-10 21:04
 */
@Entity(name = "tb_user")
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userAccount;
    private String userName;
    private String password;
    private Integer userType = UserTypeEnum.USER_TYPE_NORMAL.getCode();
    private String temp;

    //默认 男
    private Integer sex = SexEnum.Male.getCode();


    public User(String userAccount, String password) {
        this.userAccount = userAccount;
        this.password = password;
    }

    public User(String userAccount, String userName, String password, Integer userType, Integer sex) {
        this.userAccount = userAccount;
        this.userName = userName;
        this.password = password;
        this.userType = userType;
        this.sex = sex;
    }


}
