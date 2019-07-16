package cn.zhonggong.makeup.vo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 军辉
 * 2019-07-16 20:20
 */
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class NavigationVO<T> {
    private String mainName;
    private T childName;

    public NavigationVO(String mainName, T childName) {
        this.mainName = mainName;
        this.childName = childName;
    }
}
