package com.example.admin.dailyquote;

import android.app.Application;

import com.example.admin.dailyquote.managers.Preferences;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by Admin on 10/12/2016.
 */

public class QuoteApplication extends Application {
    @Override
    public void onCreate() {

        super.onCreate();

        Preferences.init(this);
        initImageLoader();

    }
    private void initImageLoader() {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);
    }
}
