package com.liuwei.safety;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.NumberFormat;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wee
 * @Description:
 * @date 2020/4/19 19:31
 */
public class User extends Thread {
    private final String name;
    private final String address;
    private final Gate gate;

    public User(String name, String address, Gate gate) {
        this.name = name;
        this.address = address;
        this.gate = gate;
    }

    public User() {
        this("", "", new Gate());
    }

    private void print() {
        System.out.println("我被调用了..");
    }

    @Override
    public void run() {
        while (true) {
            gate.pass(name, address);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

       /* NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        percentInstance.setMaximumFractionDigits(3);

        Gate gate = new Gate();
        User bj = new User("Bobo","Beijing", gate);
        User sh = new User("Sill","Shanghai", gate);
        User cd = new User("Cuy","Chengdu", gate);

        bj.start();
        sh.start();
        cd.start();*/
        Class<?> userClass = Class.forName("com.liuwei.safety.User");
//        Method print = userClass.getMethod("print");
        Method print = userClass.getDeclaredMethod("print");
        print.setAccessible(true);
        print.invoke(userClass.newInstance());
    }
}
