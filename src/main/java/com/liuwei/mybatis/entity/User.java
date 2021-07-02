package com.liuwei.mybatis.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @author wee
 * @Description:
 * @date 2020/6/29 17:45
 */
@Alias("user")
public class User implements Serializable {

    public String id;
    public String name;
    public String age;
    public String sexId;
    public UserSex userSex;

    public User() {
        this("", "", "");
    }

    public User(String name, String age, String sexId) {
        this.name = name;
        this.age = age;
        this.sexId = sexId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSexId() {
        return sexId;
    }

    public void setSexId(String sexId) {
        this.sexId = sexId;
    }

    public UserSex getUserSex() {
        return userSex;
    }

    public void setUserSex(UserSex userSex) {
        this.userSex = userSex;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
