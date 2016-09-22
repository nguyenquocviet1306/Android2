package com.example.viet.contactcompany;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    DetailFragment detailFragment;
    int position = 0;
    private Company company;
    public static final String EXTRA_CONTACT = "Contact";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getDataFromIntent();
        onDetailFragment();
        getReferences();
        setupUI();
    }

    private void setupUI() {
    }

    private void getReferences() {
    }

    private void onDetailFragment() {
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setCompany(company);
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_contact_detail_container, detailFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        company = (Company) intent.getSerializableExtra(EXTRA_CONTACT);
    }
}
