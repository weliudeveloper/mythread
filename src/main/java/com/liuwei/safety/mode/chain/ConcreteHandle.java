package com.liuwei.safety.mode.chain;

/**
 * @author wee
 * @Description: 使多个对象都有机会处理请求，从而避免请求的发送者和接受者之间的耦合关系，
 * 将这个对象连成一条链，并沿着这条链传递该请求，直到有一个对象处理他为止。
 * @date 2020/4/15 11:51
 */
public class ConcreteHandle extends Handler {

    @Override
    public void handlerRequest() {
        if (getHandler() != null) {
            System.out.println("放过请求");
            getHandler().handlerRequest();
        } else {
            System.out.println("处理请求");
        }
    }

    public static void main(String[] args) {
        ConcreteHandle concreteHandle = new ConcreteHandle();
        ConcreteHandle concreteHandle1 = new ConcreteHandle();
        concreteHandle.setHandler(concreteHandle1);
        concreteHandle.handlerRequest();
    }
}
