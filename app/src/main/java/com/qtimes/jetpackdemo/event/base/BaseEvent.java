/**
 * Created with JackHou
 * Date: 2021/3/6
 * Time: 9:16
 * Description:
 */

package com.qtimes.jetpackdemo.event.base;

public class BaseEvent {
    private int action;

    public BaseEvent(int action) {
        this.action = action;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }
}
