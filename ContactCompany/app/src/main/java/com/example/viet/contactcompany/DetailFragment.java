package com.example.viet.contactcompany;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DetailFragment extends Fragment {

    private Company company;
    private TextView tvName;
    private TextView tvTel;
    private TextView tvEmail;




    public DetailFragment() {

    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//
//    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_detail,container, false);
        getReferences(view);
        setupUI();
        addListener();
        return view;
    }

    private void setupUI() {
        tvName.setText(company.getName());
        tvTel.setText(company.getTel());
        tvEmail.setText(company.getEmail());
    }

    private void getReferences(View view){
        tvName = (TextView)view.findViewById(R.id.tv_name);
        tvTel = (TextView) view.findViewById(R.id.tv_tel);
        tvEmail = (TextView) view.findViewById(R.id.tv_email);
    }

    private void addListener() {
        tvEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String googleSearchString = String.format("http://google.com/search?q=%s",company.getEmail());
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(googleSearchString));
                startActivity(intent);

            }
        });

    }



    public void setCompany(Company company){
        this.company = company;
    }
}

