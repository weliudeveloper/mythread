package com.liuwei.springan.controller;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.function.Predicate;

/**
 * @author wee
 * @Description:
 * @date 2020/6/23 11:28
 */
public class OrderBookImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.liuwei.springan.entity.Book"};
    }

    @Override
    public Predicate<String> getExclusionFilter() {
        return null;
    }
}
