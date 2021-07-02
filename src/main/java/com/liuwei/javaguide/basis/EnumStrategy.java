package com.liuwei.javaguide.basis;

/**
 * 枚举的策略模式
 *
 * @Author wee
 */
public enum EnumStrategy {

    /**
     * RED
     */
    RED {
        @Override
        public void duc() {
            System.out.println("我是红色哦");
        }
    },
    /**
     * BLACK
     */
    BLACK {
        @Override
        public void duc() {
            System.out.println("我是黑色呀");
        }
    };

    public abstract void duc();
}
