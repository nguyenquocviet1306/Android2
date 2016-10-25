package com.example.admin.categories2.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.admin.categories2.R;
import com.example.admin.categories2.models.Food;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Admin on 10/25/2016.
 */

public class FoodViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_food)
    public ImageView ivFood;

    @BindView(R.id.tv_food)
    public TextView tvFood;



    public FoodViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void bind(Food food) {
        tvFood.setText(food.getTitle());
        ivFood.setImageResource(food.getImageResId());
    }

}
