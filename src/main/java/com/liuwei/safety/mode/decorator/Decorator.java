package com.liuwei.safety.mode.decorator;

/**
 * @author wee
 * @Description:
 * @date 2020/4/14 17:19
 */
public abstract class Decorator extends Man {

    protected Person person;

    public void setPerson(Person person) {
        this.person = person;
    }

    public void eat() {
        person.eat();
    }
}
