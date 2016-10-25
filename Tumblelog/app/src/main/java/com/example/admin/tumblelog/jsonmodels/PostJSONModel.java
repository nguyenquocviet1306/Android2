package com.example.admin.tumblelog.jsonmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Admin on 10/24/2016.
 */

public class PostJSONModel {
    @SerializedName("title")
    private String title;

    @SerializedName("content")
    private String content;

    public PostJSONModel(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
