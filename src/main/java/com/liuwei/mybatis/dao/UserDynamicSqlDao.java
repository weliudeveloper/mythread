package com.liuwei.mybatis.dao;

import com.liuwei.mybatis.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wee
 * @Description:
 * @date 2020/7/1 10:22
 */
public interface UserDynamicSqlDao {

    public List<User> getList(@Param(value = "userId") String userId, @Param(value = "name") String name);

    public Boolean updateUser(@Param(value = "user") User user, @Param(value = "id") String id);

    public List<User> getListByIds(@Param(value = "ids") List<String> ids);
}
