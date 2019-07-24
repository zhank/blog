package cn.service;

import cn.entity.TbMessage;

import java.util.List;

public interface MessageService {

    /**
     * 获取留言个数
     * @return
     */
    public int getMessageCount();

    public int insertUserMsg(TbMessage TbMessage);

    public List<TbMessage> getMessageList(int pageNum, int pageSize);
}
