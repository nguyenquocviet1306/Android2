package com.example.admin.checklogin;

import android.app.Service;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.checklogin.contents.Constant;
import com.example.admin.checklogin.models.JSONModel;
import com.example.admin.checklogin.network.LoginServer;
import com.google.gson.Gson;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;

    Retrofit loginRetrofit;
    LoginServer loginServer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        loginRetrofit = new Retrofit
                .Builder()
                .baseUrl("https://a5-tumblelog.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        loginServer = loginRetrofit.create(LoginServer.class);
    }
    @OnClick(R.id.bt_login)
    public void login() {
        User user = new User(
                etUsername.getText().toString(),
                etPassword.getText().toString()
        );



        final Gson gson = new Gson();
        String jsonBody = gson.toJson(user);
        final RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),jsonBody);
//        Request request = new Request.Builder().url(Constant.TUMBLE_URL).post(requestBody).build();
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.d(TAG, String.format("onFailure:%s", e));
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                String body = response.body().string();
//                JSONModel jsonModel = gson.fromJson(body,JSONModel.class);
//                if (jsonModel.getCode() == 1){
//                    makeToast("Loggin success !");
//                } else {
//                     makeToast("Sorry,Loggin failed.  Try again !");
//                }
//            }
//        });
        retrofit2.Call<JSONModel> jsonModelCall = loginServer.login("login",requestBody);
        jsonModelCall.enqueue(new retrofit2.Callback<JSONModel>() {
            @Override
            public void onResponse(retrofit2.Call<JSONModel> call, retrofit2.Response<JSONModel> response) {
                JSONModel jsonModel = response.body();
                if (jsonModel.getCode() == 1) {
                    makeToast("Login success");
                    Log.d(TAG,"Login success");
                }
                else {
                    makeToast("Login fail");
                    Log.d(TAG,"Login fail");
                }
            }

            @Override
            public void onFailure(retrofit2.Call<JSONModel> call, Throwable t) {

            }
        });
    }

    private void makeToast(final String mess){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this,
                        mess,Toast.LENGTH_SHORT).show();
            }
        });
    }


}
