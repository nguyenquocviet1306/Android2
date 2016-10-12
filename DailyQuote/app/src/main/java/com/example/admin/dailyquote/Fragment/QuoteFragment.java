package com.example.admin.dailyquote.Fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.dailyquote.MainActivity;
import com.example.admin.dailyquote.R;
import com.example.admin.dailyquote.constants.Constants;
import com.example.admin.dailyquote.jsonmodels.QuoteJSONModel;
import com.example.admin.dailyquote.managers.Preferences;
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

import static com.example.admin.dailyquote.constants.Constants.QUOTE_API;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuoteFragment extends Fragment {

    private static final String TAG = QuoteFragment.class.toString();
    @BindView(R.id.inv_background)
    ImageView invBackground;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.tv_usernam)
    TextView tvUserName;



    public QuoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_quote, container, false);
        ButterKnife.bind(this,view);

        setupUI();
        return  view;
    }

    private void updateQuote(final QuoteJSONModel quoteJSONModel){
        Activity parent = getActivity();
        parent.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvTitle.setText(quoteJSONModel.getTitle());
                tvContent.setText(Html.fromHtml(quoteJSONModel.getContent()));
            }
        });
    }
    private void setupUI() {
        //Username
        tvUserName.setText(String.format("Hi, %s", Preferences.getInstance().getUsername()));
        //Image
        ImageLoader.getInstance().displayImage(Constants.UNSPLASH_API,invBackground);

        //1 Create Client
        OkHttpClient client = new OkHttpClient();
        // 2 Create Request
        final Request request = new Request.Builder().url(QUOTE_API).build();
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

                // Create Gson
                Gson gson = new Gson();

                // Parse
                QuoteJSONModel[] quote =  gson.fromJson(bodyString, QuoteJSONModel[].class);
                if (quote.length > 0) {


                    QuoteFragment.this.updateQuote(quote[0]);


                }
            }
        });


    }

}
