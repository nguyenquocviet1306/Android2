package com.example.admin.tumblelog.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 10/25/2016.
 */

public class Post {
    private String title;
    private String content;

    public Post(String title, String content) {
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

    public static final List<Post> list = new ArrayList<>();
}
