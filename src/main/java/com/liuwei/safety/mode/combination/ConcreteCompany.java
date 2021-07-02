package com.liuwei.safety.mode.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wee
 * @Description:
 * @date 2020/4/14 16:33
 */
public class ConcreteCompany extends Company {

    private List<Company> childrenCompany = new ArrayList<Company>();

    public ConcreteCompany(String name) {
        super(name);
    }

    @Override
    public void add(Company company) {

    }

    @Override
    public void remove(Company company) {

    }

    @Override
    public void display(int depth) {

    }

    @Override
    public void lineofDuty() {

    }
}
