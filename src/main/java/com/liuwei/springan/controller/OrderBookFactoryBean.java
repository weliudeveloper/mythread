package com.liuwei.springan.controller;

import com.liuwei.springan.entity.Book;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author wee
 * @Description:
 * @date 2020/6/23 11:58
 */
public class OrderBookFactoryBean implements FactoryBean<Book> {
    @Override
    public Book getObject() throws Exception {
        return new Book();
    }

    @Override
    public Class<?> getObjectType() {
        return Book.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
