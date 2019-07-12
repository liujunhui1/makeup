package cn.zhonggong.makeup.domain;

import cn.zhonggong.makeup.enums.SexEnum;
import cn.zhonggong.makeup.enums.UserTypeEnum;
import lombok.Data;

import javax.persistence.*;

/**
 * 军辉
 * 2019-07-10 21:04
 */
@Entity(name = "tb_user")
@Data
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

    public User() {
    }

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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userAccount='" + userAccount + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                ", temp='" + temp + '\'' +
                ", sex=" + sex +
                '}';
    }
}
