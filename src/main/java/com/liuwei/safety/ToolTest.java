package com.liuwei.safety;

/**
 * @author wee
 * @Description:
 * @date 2020/10/14 10:21
 */
public class ToolTest {

    public static void main(String[] args) {
        InterfaceTool interfaceTool = new AbstractTool() {
            @Override
            public void insert1() {
                System.out.println("我在调用insert1");
            }
        };
        interfaceTool.insert2();
    }
}
