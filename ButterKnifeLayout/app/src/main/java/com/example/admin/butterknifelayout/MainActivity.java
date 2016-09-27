package com.example.admin.butterknifelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.avatar) ImageView imgAvatar;
    @BindView(R.id.bit_map_1) ImageView bitmap1;
    @BindView(R.id.bit_map_2) ImageView bitmap2;
    @BindView(R.id.bit_map_3) ImageView bitmap3;
    @BindView(R.id.bit_map_4) ImageView bitmap4;
    @BindView(R.id.bit_map_6) ImageView bitmap6;
    @BindView(R.id.bit_map_7)ImageView bitmap7;
    @BindView(R.id.bit_map_8) ImageView bitmap8;
    @BindView(R.id.bit_map_11) ImageView bitmap11;
    @BindView(R.id.bit_map_12) ImageView bitmap12;
    @BindView(R.id.bit_map) ImageView bitmap;
    @BindView(R.id.play_icon) ImageView playicon;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupUI();
    }

    private void setupUI() {
        imgAvatar.setImageResource(R.drawable.oval_avatar);
        bitmap.setImageResource(R.drawable.bitmap1);
        bitmap2.setImageResource(R.drawable.bitmap2);
        bitmap3.setImageResource(R.drawable.bitmap3);
        bitmap4.setImageResource(R.drawable.bitmap4);
        bitmap6.setImageResource(R.drawable.bitmap6);
        bitmap7.setImageResource(R.drawable.bitmap7);
        bitmap8.setImageResource(R.drawable.bitmap8);
        bitmap11.setImageResource(R.drawable.bitmap11);
        bitmap12.setImageResource(R.drawable.bitmap12);
        bitmap1.setImageResource(R.drawable.bitmap1);
        playicon.setImageResource(R.drawable.play_icon_group);
    }
}
