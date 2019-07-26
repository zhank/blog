package cn.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 关键字表
 */
@Getter
@Setter
public class TbKeyword {

    //关键字ID
    private String keywordId;

    //名字
    private String keywordName;

    //添加时间
    private Date keywordDate;

    //修改日期
    private Date keywordUpdate;

    //添加人
    private String keywordUserId;
}
