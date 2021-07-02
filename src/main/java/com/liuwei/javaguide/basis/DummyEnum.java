package com.liuwei.javaguide.basis;

/**
 * @author wee
 * <p>
 * DummyEnum
 */
public enum DummyEnum {
    /**
     * RED
     */
    RED("红色", 1),
    /**
     * BLACK
     */
    BLACK("黑色", 2);
    private String name;
    private Integer code;

    DummyEnum(String name, Integer code) {
        this.name = name;
        this.code = code;
    }


    public String getName() {
        return name;
    }
}
