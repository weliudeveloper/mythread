package com.liuwei.safety.mode.bridge;

/**
 * @author wee
 * @Description: 扩展抽象化角色，改变和修正父类对抽象化的定义
 * @date 2020/4/14 16:11
 */
public class RefinedAbstraction extends Abstraction {
    @Override
    public void operation() {
        impl.operationImpl();
    }

    public static void main(String[] args) {

    }
}
