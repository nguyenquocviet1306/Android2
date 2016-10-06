package com.example.admin.lap04;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.list_item)
    ListView lvItem;
    private static final String ARRAY[] = new String[] {
        "Newspapers","Setting","Payment","Amout","Setting 2"
    };
    private ArrayList<String> ListArray =
            new ArrayList<>(Arrays.asList(ARRAY));

    private ArrayAdapter<String> listArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupUI();
        addListener();
    }



    private void setupUI() {
        listArrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                ListArray
        );
        lvItem.setAdapter(listArrayAdapter);

    }
    private void openFragment(Fragment fragment,boolean addToBackStack){
        if (addToBackStack) {
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.activity_main, fragment).addToBackStack(null).commit();
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.activity_main,fragment).commit();
        }

    }
    private void addListener() {
        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        openFragment(new ItemFragment(),true);
                        break;
                    case 1:
                        openFragment(new SettingFragment(),true );
                        break;
                    case 2:
                        openFragment(new PaymentFragment(),true);
                        break;
                    case 3:
                        openFragment(new AmountFragment(),true);
                        break;
                    case 4:
                        openFragment(new Setting2Fragment(),true);
                        break;

                }
            }
        });
    }
}
