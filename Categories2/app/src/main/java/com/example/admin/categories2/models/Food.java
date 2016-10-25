package com.example.admin.categories2.models;

import com.example.admin.categories2.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Admin on 10/25/2016.
 */

public class Food {
    private String title;
    private int imageResId;

    public Food(String title, int imageResId ) {
        this.title = title;
        this.imageResId = imageResId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageResId() {
        return imageResId;
    }
    @Override
    public String toString() {
        return this.title;
    }
    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }
//    public   Food[] list_food = new Food[]{
//            new Food("Breakfast",R.drawable.american),
//            new Food("Coffee",R.drawable.coffee),
//            new Food("Coffde",R.drawable.drinks),
//            new Food("Coffde",R.drawable.lunch),
//    };
    public final static List<Food> list = new ArrayList<>();



}
