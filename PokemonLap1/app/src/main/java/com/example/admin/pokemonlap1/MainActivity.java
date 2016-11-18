package com.example.admin.pokemonlap1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.example.admin.pokemonlap1.fragment.PlayFragment;
import com.example.admin.pokemonlap1.fragment.ScoreFragment;
import com.example.admin.pokemonlap1.fragment.SettingFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.ivPlay)
    ImageView ivPlay;
    @BindView(R.id.btSetting)
    Button btSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
    private void changeFragment(Fragment fragment, boolean addToBackStack){
        FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.activity_main,fragment);
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }

        fragmentTransaction.commit();
    }

    @OnClick(R.id.btSetting)
    public void SettingClick(Button button){
        changeFragment(new SettingFragment(),true);
    }

    @OnClick(R.id.ivPlay)
    public void PlayClick(ImageView imageView){
        changeFragment(new PlayFragment(),true);
    }


}
