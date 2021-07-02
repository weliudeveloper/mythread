package com.liuwei.mybatis.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.List;

/**
 * @author wee
 * @Description:
 * @date 2020/6/30 16:52
 */
@Alias("userSex")
public class UserSex implements Serializable {

    public String id;
    public String sex;
    public List<User> userList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "UserSex{" +
                "id='" + id + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
