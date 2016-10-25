package com.example.admin.tumblelog.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import com.example.admin.tumblelog.R;
import com.example.admin.tumblelog.adapter.PostAdapter;
import com.example.admin.tumblelog.constant.Constants;
import com.example.admin.tumblelog.jsonmodels.PostJSONModel;
import com.example.admin.tumblelog.models.Post;
import com.google.gson.Gson;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    @BindView(R.id.rv_post)
    public RecyclerView rvPost;

    private PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupUI();
        sendGETPosts();
//        sendPostRequest();
    }
    private void setupUI() {
        // 1 Setup layoutmanager
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        GridLayoutManager layoutManager = new GridLayoutManager(this,3);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        rvPost.setLayoutManager(layoutManager);

        // 2 Setup Adapter
        postAdapter = new PostAdapter();
        rvPost.setAdapter(postAdapter);
    }

    private void sendPostRequest() {
        // 1
        OkHttpClient client = new OkHttpClient();

        // 2 : Create Request
        // 2.1 : Create request data (body)
//        FormBody formBody = new FormBody.Builder()
//                .add("title","Yesterday")
//                .add("content","Oh yeah, I met my best friend")
//                .build();
        PostJSONModel postJSONModel = new PostJSONModel("Yet another day", "A new day, I hope lucky");
        String jsonBody = new Gson().toJson(postJSONModel);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),jsonBody);
        // 2.2 Create POST request
        Request request = new Request.Builder()
                .url(Constants.TUMBLE_URL)
                .post(requestBody)
                .build();

        // 2.3 Send request
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, String.format("onFailure %s" , e));

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string();
                Log.d(TAG, String.format("onResponse %s", body ));
            }
        });


    }

    private void sendGETPosts() {
        // 1
        OkHttpClient client = new OkHttpClient();
        // 2 Create Request based URL
        Request request = new Request.Builder()
                .url(Constants.TUMBLE_URL)
                .build();
        // 3 Send request
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, String.format("onFailure %s" , e));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String body = response.body().string();
                    Log.d(TAG, String.format("onResponse %s", body ));
                    PostJSONModel[] postJSONModels = (new Gson())
                            .fromJson(body,PostJSONModel[].class);
                    Post.list.clear();
                    for (PostJSONModel postJSONModel : postJSONModels) {
                        Post.list.add(
                                new Post(postJSONModel.getTitle(),postJSONModel.getContent()));
                    }
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            postAdapter.notifyDataSetChanged();

                        }
                    });
                }

            }
        });
    }
}
