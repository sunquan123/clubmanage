package com.clubmanage.ClubDemo.Pojo;

import java.util.HashMap;

public class DBRetMsg {
    private Boolean status;
    private HashMap<String,String> msg;

    public DBRetMsg() {
    }

    public DBRetMsg(Boolean status, HashMap<String,String> msg) {
        this.status = status;
        this.msg = msg;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public HashMap<String,String> getMsg() {
        return msg;
    }

    public void setMsg(HashMap<String,String> msg) {
        this.msg = msg;
    }
}
