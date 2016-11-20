package com.example.admin.pokemonlap1.fragment;


import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.example.admin.pokemonlap1.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlayFragment extends Fragment {
    ProgressBar progessBar;
    CountDownTimer countDownTimer;
    int i=0;
    @BindView(R.id.pb_progess)
    ProgressBar pbProgess;
    @BindView(R.id.ivPicture)
    ImageView ivPicture;


    public PlayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_play, container, false);
        ButterKnife.bind(this,view);
        setupUI(view);
        return view;
    }

    private void setupUI(View view){
        countTime();
        Glide.with(this).load(Uri.parse("file:///android_asset/images/Abra.png")).fitCenter().into(ivPicture);

    }


    public void countTime(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                pbProgess.setProgress(2000);
                while (pbProgess.getProgress() > 0) {
                    int s = pbProgess.getProgress();
                    s--;
                    try {
                        Thread.sleep(100);
                        pbProgess.setProgress(s);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();


    }



}
