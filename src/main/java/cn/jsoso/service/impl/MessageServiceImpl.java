package cn.jsoso.service.impl;

import cn.jsoso.dao.MessageDao;
import cn.jsoso.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
