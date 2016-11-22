package com.example.admin.pokemonlap1.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.pokemonlap1.R;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScoreFragment extends Fragment {
    @BindView(R.id.score)
    TextView scorel;


    public ScoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_score, container, false);

        return view;
    }

}
