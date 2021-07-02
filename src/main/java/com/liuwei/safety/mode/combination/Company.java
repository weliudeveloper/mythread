package com.liuwei.safety.mode.combination;

/**
 * @author wee
 * @Description: 将对象组合成树形结构以表示”部分-整体”的层次结构。组合模式使得用户对单个对象和组合对象的使用具有一致性。
 * @date 2020/4/14 16:33
 */
public abstract class Company {
    protected String name;

    public Company(String name) {
        this.name = name;
    }

    public abstract void add(Company company);//add

    public abstract void remove(Company company);//remove

    public abstract void display(int depth);//display

    public abstract void lineofDuty();//line of duty

}
