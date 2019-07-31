package cn.constant;

import lombok.Getter;
import lombok.Setter;

/**
 * 博客类型
 */
@Getter
public enum  BlogType {
    AI(1, "人工智能"),
    MOBILE_DEVELOPMENT(2, "移动开发"),
    IOT(3, "物联网"),
    FRAMEWORK(4, "架构"),
    CLOUD_BIGDATA(5, "云计算/大数据"),
    INTERNET(6, "互联网"),
    DEVOPS(7, "运维"),
    DATABASE(8, "数据库"),
    FRONT_END(9, "前端"),
    BACK_END(10, "后端"),
    PROGRAMING_LANGUAGE(11, "编程语言"),
    SECURITY(12, "安全"),
    PROCEDURAL_LIFE(13, "程序人生"),
    COMPUTER_FOUNDATION_AND_THEORY(14, "计算机基础与理论");


    private Integer id;
    private String value;

    BlogType(Integer id, String value){
        this.id = id;
        this.value = value;
    }
}
