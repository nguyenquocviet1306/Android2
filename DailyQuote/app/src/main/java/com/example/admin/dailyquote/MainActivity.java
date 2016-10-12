package com.example.admin.dailyquote;

import android.app.DownloadManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.dailyquote.Fragment.LoginFragment;
import com.example.admin.dailyquote.Fragment.QuoteFragment;
import com.example.admin.dailyquote.constants.Constants;
import com.example.admin.dailyquote.jsonmodels.QuoteJSONModel;
import com.example.admin.dailyquote.managers.Preferences;
import com.example.admin.dailyquote.models.FragmentEvent;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.admin.dailyquote.constants.Constants.QUOTE_API;

public class MainActivity extends AppCompatActivity {


    public static final String TAG = MainActivity.class.toString() ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);

        if (Preferences.getInstance().getUsername() == null){
            changeFragment(new LoginFragment(), false);
        } else {
            changeFragment(new QuoteFragment(), false);

        }


    }
    @Subscribe
    public void onEvent(FragmentEvent fragmentEvent){
        changeFragment(fragmentEvent.getFragment(),fragmentEvent.isAddToBackStack());
    }
    public void changeFragment(Fragment fragment, boolean AddToBackStack){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_container,fragment);

        if (AddToBackStack){
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }



}
