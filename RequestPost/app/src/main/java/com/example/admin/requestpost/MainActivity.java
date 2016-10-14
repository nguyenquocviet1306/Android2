package com.example.admin.requestpost;

        import  android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;

        import java.io.IOException;

        import okhttp3.Call;
        import okhttp3.Callback;
        import okhttp3.FormBody;
        import okhttp3.OkHttpClient;
        import okhttp3.Request;
        import okhttp3.RequestBody;
        import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getContent();
    }

    private void getContent() {
        OkHttpClient client = new OkHttpClient();

        RequestBody form = new FormBody.Builder().add("userId","1")
                .add("name","VietNQ").build();
        RequestBody form2 = new FormBody.Builder().add("userId","2")
                .add("name","LinhDL").build();

        Request request = new Request.Builder()
                .url("http://jsonplaceholder.typicode.com/posts")
                .post(form)
                .build();
        Request request2 = new Request.Builder()
                .url("http://jsonplaceholder.typicode.com/posts")
                .post(form2)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String bodyString = response.body().string();
                Log.d(TAG, bodyString);
            }
        });

        client.newCall(request2).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String bodyString2 = response.body().string();
                Log.d(TAG, bodyString2);
            }
        });
    }
}