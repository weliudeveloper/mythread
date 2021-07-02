package com.liuwei.springan.test;

import com.liuwei.springan.configuration.BookConfiguration;
import com.liuwei.springan.configuration.TransactionConfig;
import com.liuwei.springan.dao.PersonDao;
import com.liuwei.springan.dao.Tomcat;
import com.liuwei.springan.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wee
 */
public class BookTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TransactionConfig.class);

        UserService bean = context.getBean(UserService.class);
        bean.insert();
        System.out.println("注册Bean完成...");


    }
}
