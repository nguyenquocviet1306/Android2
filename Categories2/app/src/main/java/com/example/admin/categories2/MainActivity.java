package com.example.admin.categories2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.categories2.adapter.FoodAdapter;
import com.example.admin.categories2.models.Food;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_food)
    public RecyclerView rvFood;

    private FoodAdapter foodAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupUI();
    }

    private void setupUI() {
        // 1 Setup LayoutManager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvFood.setLayoutManager(linearLayoutManager);

        // 2 Setup Adapter
        foodAdapter = new FoodAdapter();
        rvFood.setAdapter(foodAdapter);

        Food.list.add(new Food("Breakfast",R.drawable.b2));
        Food.list.add(new Food("Coffee",R.drawable.b3));
        Food.list.add(new Food("Lunch",R.drawable.b4));
        Food.list.add(new Food("Drinks",R.drawable.b5));
        Food.list.add(new Food("Breakfast",R.drawable.b2));
        Food.list.add(new Food("Coffee",R.drawable.b3));
        Food.list.add(new Food("Lunch",R.drawable.b4));
        Food.list.add(new Food("Drinks",R.drawable.b5));


    }
}
