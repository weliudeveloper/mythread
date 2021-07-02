package com.liuwei.springan.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author wee
 * @Description:
 * @date 2020/6/28 11:43
 */
@Repository
public class UserDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public void insert() {
        String sql = "insert into user (id,name,age) values(?,?,?)";
        jdbcTemplate.update(sql, 2, "wee", 26);
    }
}
