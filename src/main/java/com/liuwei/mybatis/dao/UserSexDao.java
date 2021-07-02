package com.liuwei.mybatis.dao;

import com.liuwei.mybatis.entity.UserSex;

/**
 * @author wee
 * @Description:
 * @date 2020/6/30 17:30
 */
public interface UserSexDao {

    public UserSex getUserSex(String id);

    public UserSex getUserSexPlus(String id);

    public UserSex getUserSexStep(String id);
}
