package com.liuwei.springan.controller;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author wee
 * @Description:
 * @date 2020/6/23 11:46
 */
public class OrderBookCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        BeanDefinition getBook = beanFactory.getBeanDefinition("getBook");
        String factoryBeanName = getBook.getFactoryBeanName();
        System.out.println(factoryBeanName);
        String windows = context.getEnvironment().getProperty("os.name");
        return windows.contains("Windows");
    }
}
