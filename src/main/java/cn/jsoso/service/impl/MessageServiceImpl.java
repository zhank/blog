package cn.jsoso.service.impl;

import cn.jsoso.dao.MessageDao;
import cn.jsoso.entity.TbMessage;
import cn.jsoso.service.MessageService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 留言版实现类
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    @Override
    public int getMessageCount() {
        return messageDao.getMessageCount();
    }

    @Override
    public int insertUserMsg(TbMessage tbMessage) {
        return messageDao.insertUserMsg(tbMessage);
    }

    /**
     * 分布获取留言
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<TbMessage> getMessageList(int pageNum, int pageSize) {
        //分页
        PageHelper.startPage(pageNum, pageSize);
        return  messageDao.getAllMessage();
    }
}
