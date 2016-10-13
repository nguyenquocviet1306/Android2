package com.example.admin.lapnew06part2.jsonmodels;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 10/13/2016.
 */

public class FlickrFeed {
    @SerializedName("title")
    private String title;

    @SerializedName("items")
    private ArrayList<FlickrItem> items;

    public String getTitle() {
        return title;
    }

   public List<FlickrItem> getItems() {
        return items;
    }
}

