package cn.constant;

import lombok.Getter;

/**
 * 文章类型
 */
@Getter
public enum ArticleType {
    ORIGINAL(1, "原创"),
    REPRINT(2, "转载");

    private Integer id;
    private String value;

    ArticleType(Integer id, String value){
        this.id = id;
        this.value = value;
    }
}
