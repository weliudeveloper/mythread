package com.liuwei.safety.mode.adapter;

/**
 * @author wee
 * @Description:
 * @date 2020/4/14 15:29
 */
public class M5DataLineAdapterObj implements Target {
    private Target target;

    public M5DataLineAdapterObj(Target target) {
        this.target = target;
    }

    @Override
    public void connection() {
        System.out.println("插入 type-c 转接头...");
        target.connection();
    }

    public static void main(String[] args) {
        Target adapter = new M5DataLineAdapterObj(new M5DataLine());
        adapter.connection();
    }
}
