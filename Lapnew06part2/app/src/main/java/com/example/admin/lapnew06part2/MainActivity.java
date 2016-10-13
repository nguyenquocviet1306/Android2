package com.example.admin.lapnew06part2;

import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.admin.lapnew06part2.constants.Constants;
import com.example.admin.lapnew06part2.jsonmodels.FlickrFeed;
import com.example.admin.lapnew06part2.jsonmodels.FlickrItem;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString() ;
    private ListView lvFlickr;
    private ArrayAdapter<FlickrItem> feedArrayAdapter;
    private ArrayList<FlickrItem> flickrItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flickrItems = new ArrayList<>();
        getReferences();
        setupUI();

        getContent();
    }

    private void setupUI() {
//        feedArrayAdapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_1,
//                flickrItems
//                );
//        lvFlickr.setAdapter(feedArrayAdapter);
    }

    private void getReferences() {
        lvFlickr = (ListView) findViewById(R.id.lv_flickr);
    }

    private void getContent() {
        OkHttpClient client = new OkHttpClient();
//        ImageLoader.getInstance().displayImage(Constants.FLICK_IMAGE_API,image1);
        final Request request = new Request.Builder()
                .url("http://www.flickr.com/services/feeds/photos_public.gne?tags=girl&format=json&title=girl")
                .build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String body = response.body().string()
                            .replace("jsonFlickrFeed(","")
                            .replace("})","}");
                    final FlickrFeed flickFeed = new Gson().fromJson(body, FlickrFeed.class);

                    final List<FlickrItem> flickrItems = flickFeed.getItems();
//                    for (FlickrItem item : flickFeed.getItems()) {
//                        Log.d(TAG,item.getImageLink());
//                        flickrItems.add(item);
//                    }

                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
//                            feedArrayAdapter.notifyDataSetChanged();
                            lvFlickr.setAdapter(new Adapter(getBaseContext(), R.layout.listview, flickrItems));
                        }
                    });

//                    Log.d(TAG,flickFeed.getTitle());
                }
            });
    }


}
