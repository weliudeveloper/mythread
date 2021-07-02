package com.liuwei.safety.mode.bridge;

/**
 * @author wee
 * @Description:
 * @date 2020/10/14 14:25
 */
public class Client {

    public static void main(String[] args) {
        XiaoMi xiaoMi = new XiaoMi();
        ZdPhone zdPhone = new ZdPhone(xiaoMi);
        zdPhone.open();
    }
}
