/**
 * Created with JackHou
 * Date: 2021/3/6
 * Time: 9:24
 * Description:
 */

package com.qtimes.jetpackdemo.event.base;

public class BaseActionEvent extends BaseEvent {

    public static final int EVENT_RESOLVE = -1;
    public static final int EVENT_SHOW_LOADING_DIALOG = 1;
    public static final int EVENT_DISMISS_LOADING_DIALOG = 2;
    public static final int EVENT_SHOW_TOAST = 3;
    public static final int EVENT_FINISH = 4;
    public static final int EVENT_FINISH_WITH_RESULT_OK = 5;
    private String message;

    public BaseActionEvent(int action) {
        super(action);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
