package com.example.admin.lapnew06.jsonmodels;

/**
 * Created by Admin on 10/12/2016.
 */

public class JsonModels {

    private String title;
    private String userId;
    private String body;

    public JsonModels(String title, String userId, String body) {
        this.title = title;
        this.userId = userId;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
