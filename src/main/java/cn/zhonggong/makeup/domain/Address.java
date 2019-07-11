package cn.zhonggong.makeup.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 军辉
 * 2019-07-10 21:27
 */
@Data
@Entity(name = "tb_address")
public class Address {

    @Id
    private Integer id;

    private Integer userId;
    private String address;
    private String phone;
    private String temp;

    public Address() {
    }

    public Address(Integer id, Integer userId, String address, String phone) {
        this.id = id;
        this.userId = userId;
        this.address = address;
        this.phone = phone;
    }
}
