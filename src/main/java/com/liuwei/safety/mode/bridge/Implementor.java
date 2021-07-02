package com.liuwei.safety.mode.bridge;

/**
 * @author wee
 * @Description: 这个角色给出实现化角色的接口，但不给出具体的实现。必须指出的是，这个接口不一定和抽象化角色的接口定义相同，
 * 实际上，这两个接口可以非常不一样。实现化角色应当只给出底层操作，而抽象化角色应当只给出基于底层操作的更高一层的操作。
 * @date 2020/4/14 16:09
 */
public interface Implementor {
    public void operationImpl();
}
