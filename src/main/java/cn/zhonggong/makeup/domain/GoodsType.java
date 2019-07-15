package cn.zhonggong.makeup.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * 军辉
 * 2019-07-10 21:36
 */
@Data
@Entity(name = "tb_goodstype")
//@Table(name = "tb_goodstype")
public class GoodsType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer mainId;

    @Column(name = "main_name")
    private String mainName;
    private String childName;
    private String temp;

    public GoodsType() {
    }

    public GoodsType(Integer mainId, String mainName, String childName) {
        this.mainId = mainId;
        this.mainName = mainName;
        this.childName = childName;
    }
}
