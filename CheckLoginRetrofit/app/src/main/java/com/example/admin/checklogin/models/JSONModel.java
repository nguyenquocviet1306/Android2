package com.example.admin.checklogin.models;

/**
 * Created by Admin on 10/25/2016.
 */

public class JSONModel {
    private int code;
    private String message;

    public JSONModel(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
