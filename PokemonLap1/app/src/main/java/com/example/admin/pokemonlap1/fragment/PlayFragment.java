package com.example.admin.pokemonlap1.fragment;


import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.pokemonlap1.R;
import com.example.admin.pokemonlap1.models.Pokemon;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlayFragment extends Fragment {
    ProgressBar progessBar;
    CountDownTimer countDownTimer;
    int i=0;
    @BindView(R.id.pb_progess)
    ProgressBar pbProgess;
    @BindView(R.id.ivPicture)
    ImageView ivPicture;
    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.button3)
    Button button3;
    @BindView(R.id.button4)
    Button button4;
    @BindView(R.id.score)
    TextView score;
    int scoreNow = 0;


    public PlayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_play, container, false);
        ButterKnife.bind(this,view);
        setupUI(view);
        return view;
    }

    private void setupUI(View view){
        countTime();
        choice();

    }

    public void choice(){
//        try {
//            Thread.sleep(9000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        new CountDownTimer(1000, 800) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                button1.setBackgroundResource(R.drawable.custom_view_circular_white);
                button2.setBackgroundResource(R.drawable.custom_view_circular_white);
                button3.setBackgroundResource(R.drawable.custom_view_circular_white);
                button4.setBackgroundResource(R.drawable.custom_view_circular_white);
            }
        }.start();
        Random r = new Random();
        int i = r.nextInt(4) + 1;

        if (i == 1) {
            Pokemon pokemon1= DbHeper.getInstance().slectRandomPokemon();
            Glide.with(this).load(Uri.parse("file:///android_asset/images/"+ pokemon1.getImg())).fitCenter().into(ivPicture);
            String u1 = pokemon1.getName();
            button1.setText(u1);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    button1.setBackgroundResource(R.drawable.custom_view_circular_green);
                    scoreNow++;
                    score.setText(String.valueOf(scoreNow));


                    choice();
                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    button2.setBackgroundResource(R.drawable.custom_view_circular_red);

                    choice();
                }
            });
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    button3.setBackgroundResource(R.drawable.custom_view_circular_red);

                    choice();
                }
            });
            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    button4.setBackgroundResource(R.drawable.custom_view_circular_red);

                    choice();
                }
            });

            Pokemon pokemon2= DbHeper.getInstance().slectRandomPokemon();
            button2.setText(pokemon2.getName());
            Pokemon pokemon3= DbHeper.getInstance().slectRandomPokemon();
            button3.setText(pokemon3.getName());
            Pokemon pokemon4= DbHeper.getInstance().slectRandomPokemon();
            button4.setText(pokemon4.getName());
        } else if (i == 2) {
            Pokemon pokemon1= DbHeper.getInstance().slectRandomPokemon();
            Glide.with(this).load(Uri.parse("file:///android_asset/images/"+ pokemon1.getImg())).fitCenter().into(ivPicture);
            String u1 = pokemon1.getName();
            button2.setText(u1);

            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    button2.setBackgroundResource(R.drawable.custom_view_circular_green);
                    scoreNow++;
                    score.setText(String.valueOf(scoreNow));
                    choice();
                }
            });
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    button1.setBackgroundResource(R.drawable.custom_view_circular_red);
                    choice();
                }
            });
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    button3.setBackgroundResource(R.drawable.custom_view_circular_red);
                    choice();
                }
            });
            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    button4.setBackgroundResource(R.drawable.custom_view_circular_red);
                    choice();
                }
            });

            Pokemon pokemon2= DbHeper.getInstance().slectRandomPokemon();
            button1.setText(pokemon2.getName());
            Pokemon pokemon3= DbHeper.getInstance().slectRandomPokemon();
            button3.setText(pokemon3.getName());
            Pokemon pokemon4= DbHeper.getInstance().slectRandomPokemon();
            button4.setText(pokemon4.getName());
        } else if ( i == 3) {
            Pokemon pokemon1= DbHeper.getInstance().slectRandomPokemon();
            Glide.with(this).load(Uri.parse("file:///android_asset/images/"+ pokemon1.getImg())).fitCenter().into(ivPicture);
            String u1 = pokemon1.getName();
            button3.setText(u1);

            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    button3.setBackgroundResource(R.drawable.custom_view_circular_green);
                    scoreNow++;
                    score.setText(String.valueOf(scoreNow));
                    choice();
                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    button2.setBackgroundResource(R.drawable.custom_view_circular_red);
                    choice();
                }
            });
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    button1.setBackgroundResource(R.drawable.custom_view_circular_red);
                    choice();
                }
            });
            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    button4.setBackgroundResource(R.drawable.custom_view_circular_red);
                    choice();
                }
            });
            Pokemon pokemon2= DbHeper.getInstance().slectRandomPokemon();
            button1.setText(pokemon2.getName());
            Pokemon pokemon3= DbHeper.getInstance().slectRandomPokemon();
            button2.setText(pokemon3.getName());
            Pokemon pokemon4= DbHeper.getInstance().slectRandomPokemon();
            button4.setText(pokemon4.getName());
        } else  if (i == 4) {
            Pokemon pokemon1= DbHeper.getInstance().slectRandomPokemon();
            Glide.with(this).load(Uri.parse("file:///android_asset/images/"+ pokemon1.getImg())).fitCenter().into(ivPicture);
            String u1 = pokemon1.getName();
            button4.setText(u1);

            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    button4.setBackgroundResource(R.drawable.custom_view_circular_green);
                    scoreNow++;
                    score.setText(String.valueOf(scoreNow));
                    choice();
                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    button2.setBackgroundResource(R.drawable.custom_view_circular_red);
                    choice();
                }
            });
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    button3.setBackgroundResource(R.drawable.custom_view_circular_red);
                    choice();
                }
            });
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    button1.setBackgroundResource(R.drawable.custom_view_circular_red);
                    choice();
                }
            });
            Pokemon pokemon2= DbHeper.getInstance().slectRandomPokemon();
            button1.setText(pokemon2.getName());
            Pokemon pokemon3= DbHeper.getInstance().slectRandomPokemon();
            button3.setText(pokemon3.getName());
            Pokemon pokemon4= DbHeper.getInstance().slectRandomPokemon();
            button2.setText(pokemon4.getName());
        }

    }


    public void countTime(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                pbProgess.setProgress(2000);

                while (pbProgess.getProgress() > 0) {
                    int s = pbProgess.getProgress();
                    s--;
                    try {
                        Thread.sleep(100);
                        pbProgess.setProgress(s);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (pbProgess.getProgress() == 0) {
                }
            }
        });
        thread.start();


    }



}
