/**
 * Created with JackHou
 * Date: 2021/3/8
 * Time: 13:51
 * Description:
 */

package com.qtimes.jetpackdemo.db.enums;

public enum UserState {
    RESOLVE(-1, "未知"),
    LOGIN(1, "已登录"),
    ONLINE(2, "在线"),
    OFFLINE(3, "离线"),
    LOGOUT(4, "已退出");

    private int stateId;
    private String stateDesc;

    UserState(int stateId, String stateDesc) {
        this.stateId = stateId;
        this.stateDesc = stateDesc;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public String getStateDesc() {
        return stateDesc;
    }

    public void setStateDesc(String stateDesc) {
        this.stateDesc = stateDesc;
    }
}
