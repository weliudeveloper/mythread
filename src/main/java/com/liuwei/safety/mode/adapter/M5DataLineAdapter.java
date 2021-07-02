package com.liuwei.safety.mode.adapter;

/**
 * @author wee
 * @Description:
 * @date 2020/4/14 15:21
 */
public class M5DataLineAdapter extends M4DataLine implements Target {

    public M5DataLineAdapter(M5DataLine m5DataLine) {

    }

    @Override
    public void connection() {
        System.out.println("插入 type-c 转接头");
        super.connection();
    }

    public static void main(String[] args) {
        Target target = new M5DataLine();
        target.connection();

    }
}
