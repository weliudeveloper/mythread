package com.liuwei.springan.service;

import com.liuwei.springan.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wee
 * @Description:
 * @date 2020/6/28 11:43
 */
@Service
public class UserService {

    @Autowired
    public UserDao userDao;

    @Transactional
    public void insert() {
        userDao.insert();
        System.out.println("插入完成...");
        int i = 1 / 1;
    }
}
