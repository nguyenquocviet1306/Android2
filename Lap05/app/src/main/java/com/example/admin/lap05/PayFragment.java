package com.example.admin.lap05;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class PayFragment extends Fragment {


    public PayFragment() {
        // Required empty public constructor
    }
    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity)getActivity()).showActionBar(true);
        ((MainActivity)getActivity()).showSendMenu(true);
        ((MainActivity)getActivity()).showSearchMenu(false);


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pay, container, false);
    }

}
