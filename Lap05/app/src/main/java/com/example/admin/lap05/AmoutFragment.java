package com.example.admin.lap05;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.internal.view.SupportMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AmoutFragment extends Fragment {
    private ImageView OK;
    private View v;




    public AmoutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_amout, container, false);
        OK = (ImageView) v.findViewById(R.id.iv_ok);
        addListener(v);

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity) getActivity()).showActionBar(false);

;
    }

    public void addListener(View v){
        OK = (ImageView) v.findViewById(R.id.iv_ok);
        OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ((MainActivity)getActivity()).popAll();
                getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                ((MainActivity) getActivity()).showActionBar(true);
                ((MainActivity) getActivity()).showSendMenu(false);
            }
        });
    }



}
