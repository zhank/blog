package cn.jsoso.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 留言版
 */
@Getter
@Setter
public class TbMessage {

    //留言版ID
    private String messageId;

    //用户ID
    private String userId;

    //标题
    private String messageTitle;

    //作者 一般只有没有userId时，默认为游客登录系统才会自动填充此值
    private String messageAuthor;

    //留言内容
    private String messageContent;

    //留言时间
    private Date messageTime;

}
