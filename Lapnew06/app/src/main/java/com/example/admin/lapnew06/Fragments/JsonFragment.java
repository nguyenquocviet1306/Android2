package com.example.admin.lapnew06.Fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.admin.lapnew06.R;
import com.example.admin.lapnew06.adapters.JsonAdapter;
import com.example.admin.lapnew06.constants.Constants;
import com.example.admin.lapnew06.jsonmodels.JsonModels;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.admin.lapnew06.constants.Constants.FLICKR_API;
import static com.example.admin.lapnew06.constants.Constants.FLICK_IMAGE_API;

/**
 * A simple {@link Fragment} subclass.
 */
public class JsonFragment extends Fragment {

    private static final String TAG = JsonFragment.class.toString() ;
    @BindView(R.id.lv_information)
    ListView lvInfor;



    public JsonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_json, container, false);
        ButterKnife.bind(this,view);
        setupUI();
        return view;
    }
    private void updateQuote(final JsonModels[] JSONModel){
        Activity parent = getActivity();
        parent.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                JsonAdapter jsonAdapter = new JsonAdapter(
                        getContext(),
                        android.R.layout.simple_list_item_1,
                        JSONModel
                );
                lvInfor.setAdapter(jsonAdapter);

            }
        });
    }

    private void setupUI() {
        //Username
//        tvUserName.setText(String.format("Hi, %s", Preferences.getInstance().getUsername()));
        //Image
//        ImageLoader.getInstance().displayImage(Constants.FLICK_IMAGE_API,);

        //1 Create Client
        OkHttpClient client = new OkHttpClient();
        // 2 Create Request
        final Request request = new Request.Builder().url(FLICKR_API).build();
//        final Request request = new Request.Builder().url(FLICK_IMAGE_API).build();
        //3 Send and handle
        client.newCall(request).enqueue(new Callback() {


            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG,"onFailure");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d(TAG,"onResponse");
                String bodyString = response.body().string();
                Log.d(TAG, String.format("bodyString: %s ",bodyString ));
                if (bodyString != null) {
                    // Create Gson
                    Gson gson = new Gson();

                    // Parse
                    JsonModels[] jsoniteam =  gson.fromJson(bodyString, JsonModels[].class);

                    JsonFragment.this.updateQuote(jsoniteam);
                }




            }
        });


    }

}
