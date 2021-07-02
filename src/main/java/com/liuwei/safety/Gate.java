package com.liuwei.safety;

/**
 * @author wee
 * @Description:
 * @date 2020/4/19 19:25
 */
public class Gate {

    private int count = 0;
    private String name = "Nobody";
    private String address = "Nowhere";

    private final Object LOCK = new Object();

    public void pass(String name, String address) {
        synchronized (LOCK) {
            count++;
            this.name = name;
            this.address = address;
            verify();
        }
    }

    private void verify() {
        if (this.name.charAt(0) != this.address.charAt(0)) {
            System.out.println("BROKEN---" + toString());
        }
    }

    public String toString() {
        return getCount() + "----" + getName() + "-------" + getAddress();
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
