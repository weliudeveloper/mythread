package com.liuwei.safety.mode.factory;

/**
 * @author wee
 * @Description:
 * @date 2020/4/14 11:34
 */
public class AkBullet implements Bullet {

    public AkBullet() {
        System.out.println("the ak bullet is created");
    }

    @Override
    public void load() {
        System.out.println("the ak bullet is load");
    }
}
