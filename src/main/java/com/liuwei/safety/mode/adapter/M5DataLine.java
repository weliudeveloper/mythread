package com.liuwei.safety.mode.adapter;

/**
 * @author wee
 * @Description:
 * @date 2020/4/14 15:19
 */
public class M5DataLine implements Target {

    @Override
    public void connection() {
        System.out.println("使用小米5链接");
    }

}
