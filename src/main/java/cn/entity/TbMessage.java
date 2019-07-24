package cn.entity;

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
    private String userName;

    //留言内容
    private String msgContent;

    //用户IP
    private String userIp;

    //留言时间
    private Date msgDate;

    //头像Url
    private String headUrl;

}
