package com.liuwei.springan.dao;

import org.springframework.stereotype.Repository;

/**
 * @author wee
 * @Description:
 * @date 2020/6/24 10:22
 */
@Repository
public class PersonDao {

    private String name;
    private Integer age = 1;

    public PersonDao() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
