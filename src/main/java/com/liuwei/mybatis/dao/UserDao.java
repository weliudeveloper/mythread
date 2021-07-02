package com.liuwei.mybatis.dao;

import com.liuwei.mybatis.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author wee
 * @Description:
 * @date 2020/6/30 9:48
 */
public interface UserDao {

    @Select("SELECT * FROM user")
    List<User> selectBlog(@Param(value = "pageNum") int pageNum, @Param(value = "pageSize") int pageSize);

}
