package cn.service.impl;

import cn.dao.UserDao;
import cn.entity.TbUser;
import cn.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: sfpy
 * @Date: 5/14/2019 11:50 AM
 * @Descirption
 * @Version 1.0
 */
@Service
@Transactional
public class IUserServiceImp implements IUserService {

    @Autowired
    private UserDao userDao;


    @Override
    public void addUser(TbUser user) {
        userDao.addUser(user);
    }

    @Override
    public void updateUser(TbUser user) {

    }


    @Override
    public void deleteUser(List<String> userIdList) {
        for(String userId : userIdList) {
            // 删除人员
            userDao.deleteUserById(userId);
        }
    }

    /**
     * 查询用户是否存在
     * @param userName
     * @return
     */
    @Override
    public int getCountByUserName(String userName) {
        return userDao.getCountByUserName(userName);
    }

    @Override
    public int userLogin(String userName, String password) {

        return userDao.userLogin(userName, password);
    }

    @Override
    public TbUser getUserByAccount(String userName, String password) {
        TbUser user = userDao.findUserByAccount(userName, password);
        return user;
    }


    @Override
    public List<TbUser> getAllUserList() {
        return userDao.getAllUserList();
    }

}
