package cn.service.impl;

import cn.dao.MessageDao;
import cn.entity.TbMessage;
import cn.service.IMessageService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 留言版实现类
 */
@Service
public class IMessageServiceImpl implements IMessageService {

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
