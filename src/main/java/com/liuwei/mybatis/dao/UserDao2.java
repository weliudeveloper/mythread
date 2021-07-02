package com.liuwei.mybatis.dao;

import com.liuwei.mybatis.entity.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wee
 * @Description:
 * @date 2020/6/30 10:11
 */
public interface UserDao2 {

    public User getOne(@Param(value = "id") int id, @Param(value = "name") String name);

    public User getStep(String id);

    public List<User> getUserList(String id);

    @MapKey("id")
    public Map<Integer, User> getMap(String name);

    public Integer addOne(User user);

    public Boolean deleteOne(int id);

    public Integer updateOne(User user);
}
