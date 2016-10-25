package com.example.admin.categories2.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.admin.categories2.R;
import com.example.admin.categories2.models.Food;
import com.example.admin.categories2.viewholder.FoodViewHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Admin on 10/25/2016.
 */

public class FoodAdapter extends RecyclerView.Adapter<FoodViewHolder> {

    //Create new
    @Override
    public FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 1 Inflate View
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.food_items,parent,false);
         // 2 Create View Holder
        FoodViewHolder foodViewHolder = new FoodViewHolder(itemView);


        return foodViewHolder;
    }

    @Override
    public void onBindViewHolder(FoodViewHolder holder, int position) {
        // Model
        Food food = Food.list.get(position);
        holder.bind(food);

    }

    @Override
    public int getItemCount() {
        return Food.list.size();
    }
}
