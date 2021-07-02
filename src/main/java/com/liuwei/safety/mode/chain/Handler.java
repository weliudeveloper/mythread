package com.liuwei.safety.mode.chain;

/**
 * @author wee
 * @Description:
 * @date 2020/4/15 11:50
 */
public abstract class Handler {

    protected Handler handler;

    public abstract void handlerRequest();

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
