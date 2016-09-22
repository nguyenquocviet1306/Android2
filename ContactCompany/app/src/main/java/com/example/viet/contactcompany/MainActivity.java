package com.example.viet.contactcompany;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   private List<Company> companyList;
    private ListView lvComputer;
    private FrameLayout flContainerMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1;
        setContentView(R.layout.activity_main);
        initData();
        //2
        getRefererces();
        //3
        setupUIProperties();
        //4
        addListerers();
    }

    private void getRefererces() {

        lvComputer = (ListView) findViewById(R.id.lv_computer);
        flContainerMain = (FrameLayout) findViewById(R.id.fl_detail_contact_main);
    }


    private void setupUIProperties() {
        ArrayAdapter<Company> companyAdapter = new ArrayAdapter<Company>(
                this,
                android.R.layout.simple_list_item_1,
                companyList
        );
        lvComputer.setAdapter(companyAdapter);
    }


    private void initData() {
        companyList = Company.getCompanyList();


    }

    private void addListerers() {
        lvComputer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Company company = companyList.get(position);
//                if (findViewById(R.id.fl_container) == null) {
//                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
//                    intent.putExtra(DetailActivity.EXTRA_COMPANY, company);
//                    startActivity(intent);
//                } else {
                DetailFragment detailFragment = new DetailFragment();
                detailFragment.setCompany(company);
                FragmentManager framentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = framentManager.beginTransaction();

//                FrameLayout flContainerMain = (FrameLayout) findViewById(R.id.fl_detail_contact_main);
                if (flContainerMain != null) {
//                    flContainerMain.setVisibility(View.VISIBLE);
                    fragmentTransaction.add(R.id.fl_detail_contact_main, detailFragment);

                } else {
                    fragmentTransaction.replace(R.id.fl_container, detailFragment);
                }
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }



//            }
        });
    }

}



