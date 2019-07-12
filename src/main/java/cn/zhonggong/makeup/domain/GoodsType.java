package cn.zhonggong.makeup.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 军辉
 * 2019-07-10 21:36
 */
@Data
@Entity(name = "tb_goodstype")
public class GoodsType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer mainId;
    private String mainName;
    private String childName;
    private String temp;

    public GoodsType() {
    }

    public GoodsType(Integer id, Integer mainId, String mainName, String childName, String temp) {
        this.id = id;
        this.mainId = mainId;
        this.mainName = mainName;
        this.childName = childName;
        this.temp = temp;
    }
}
