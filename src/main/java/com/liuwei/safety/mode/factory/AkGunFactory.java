package com.liuwei.safety.mode.factory;

/**
 * @author wee
 * @Description:
 * @date 2020/4/14 11:37
 */
public class AkGunFactory implements GunFactory {

    @Override
    public Gun getGun() {
        return new AkGun();
    }

    @Override
    public Bullet getBullet() {
        return new AkBullet();
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        AkGunFactory factory = (AkGunFactory) Class.forName(AkGunFactory.class.getName()).newInstance();
        AkGun gun = (AkGun) factory.getGun();
        AkBullet bullet = (AkBullet) factory.getBullet();
        gun.shoot();
        bullet.load();
    }
}
