package com.codyy.cms.events.cls;

public class StartSigninEvent {

    /**
     * number : 1
     * timeout : 20
     */

    private int number;
    private int timeout;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}
