package com.liuwei.safety.mode.factory;

/**
 * @author wee
 * @Description:
 * @date 2020/4/14 11:31
 */
public class AkGun implements Gun {

    public AkGun() {
        System.out.println("the ak is created");
    }

    @Override
    public void shoot() {
        System.out.println("AK is shooting");
    }

    public void price() {
        System.out.println("the ak is 25$");
    }
}
