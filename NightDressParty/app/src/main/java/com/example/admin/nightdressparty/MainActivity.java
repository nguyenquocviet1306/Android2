package com.example.admin.nightdressparty;

import android.app.FragmentManager;
import android.support.v4.app.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getRefereces();
        addListener();
    }
    private void getRefereces() {
        bt = (Button) findViewById(R.id.button);
    }



    private void addListener() {
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                NightDressFragment night = new NightDressFragment();
                night.show(fragmentManager,"fragment_edit_name");

            }
        });

    }



}
