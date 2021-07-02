package com.liuwei.springan.service;

import com.liuwei.springan.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wee
 * @Description:
 * @date 2020/6/24 10:22
 */
@Service
public class PersonService {


    @Autowired(required = false)
//    @Qualifier(value = "getPerson")
//    @Resource
    private PersonDao personDao;
}
