package com.example.admin.pokemonlap1.fragment;


import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
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
import com.example.admin.pokemonlap1.MainActivity;
import com.example.admin.pokemonlap1.R;
import com.example.admin.pokemonlap1.models.Pokemon;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlayFragment extends Fragment {
    CountDownTimer countDownTimer;
    int time= 20;
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
    private Bitmap loadImageFromAsset(Pokemon pokemon) {
        AssetManager assetManager = getActivity().getAssets();
        InputStream inputStream = null;
        try {
            inputStream = assetManager.open("images/" + pokemon.getImg());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
        return bitmap;
    }
    private void setImageBlack(Pokemon pokemon) {
        Bitmap bitmap = loadImageFromAsset(pokemon);
        Bitmap b = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        for (int x = 0; x < b.getWidth(); x++) {
            for (int y = 0; y < b.getHeight(); y++) {
                if (b.getPixel(x, y) != Color.TRANSPARENT) {

                    b.setPixel(x, y, Color.BLACK);
                }
            }
        }
        ivPicture.setImageBitmap(b);
    }
    public void Time(){
        new CountDownTimer(3000, 1000) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                button1.setBackgroundResource(R.drawable.custom_view_circular_white);
                button2.setBackgroundResource(R.drawable.custom_view_circular_white);
                button3.setBackgroundResource(R.drawable.custom_view_circular_white);
                button4.setBackgroundResource(R.drawable.custom_view_circular_white);
            }
        }.start();
    }


    public void choice(){
        Pokemon pokemon;

//        try {
//            Thread.sleep(9000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        Random r = new Random();
        int i = r.nextInt(4) + 1;

        if (i == 1) {
            final Pokemon pokemon1= DbHeper.getInstance().slectRandomPokemon();
            setImageBlack(pokemon1);
            String u1 = pokemon1.getName();
            button1.setText(u1);
            Pokemon pokemon2= DbHeper.getInstance().slectRandomPokemon();
            button2.setText(pokemon2.getName());
            Pokemon pokemon3= DbHeper.getInstance().slectRandomPokemon();
            button3.setText(pokemon3.getName());
            Pokemon pokemon4= DbHeper.getInstance().slectRandomPokemon();
            button4.setText(pokemon4.getName());
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Glide.with(getContext()).load(Uri.parse("file:///android_asset/images/"+ pokemon1.getImg())).fitCenter().into(ivPicture);
                    button1.setBackgroundResource(R.drawable.custom_view_circular_green);
                    scoreNow++;
                    score.setText(String.valueOf(scoreNow));
                    Time();
                    choice();
                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Glide.with(getContext()).load(Uri.parse("file:///android_asset/images/"+ pokemon1.getImg())).fitCenter().into(ivPicture);
                    button2.setBackgroundResource(R.drawable.custom_view_circular_red);
                    button1.setBackgroundResource(R.drawable.custom_view_circular_green);
                    Time();
                    choice();
                }
            });
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Glide.with(getContext()).load(Uri.parse("file:///android_asset/images/"+ pokemon1.getImg())).fitCenter().into(ivPicture);

                    button3.setBackgroundResource(R.drawable.custom_view_circular_red);
                    button1.setBackgroundResource(R.drawable.custom_view_circular_green);

                    Time();


                    choice();
                }
            });
            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Glide.with(getContext()).load(Uri.parse("file:///android_asset/images/"+ pokemon1.getImg())).fitCenter().into(ivPicture);
                    button4.setBackgroundResource(R.drawable.custom_view_circular_red);
                    button1.setBackgroundResource(R.drawable.custom_view_circular_green);

                    Time();


                    choice();
                }
            });


        } else if (i == 2) {
            final Pokemon pokemon5= DbHeper.getInstance().slectRandomPokemon();
            setImageBlack(pokemon5);
            String u1 = pokemon5.getName();
            button2.setText(u1);
            Pokemon pokemon2= DbHeper.getInstance().slectRandomPokemon();
            button1.setText(pokemon2.getName());
            Pokemon pokemon3= DbHeper.getInstance().slectRandomPokemon();
            button3.setText(pokemon3.getName());
            Pokemon pokemon4= DbHeper.getInstance().slectRandomPokemon();
            button4.setText(pokemon4.getName());

            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Glide.with(getContext()).load(Uri.parse("file:///android_asset/images/"+ pokemon5.getImg())).fitCenter().into(ivPicture);

                    button2.setBackgroundResource(R.drawable.custom_view_circular_green);
                    scoreNow++;
                    score.setText(String.valueOf(scoreNow));
                    Time();

                    choice();
                }
            });
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Glide.with(getContext()).load(Uri.parse("file:///android_asset/images/"+ pokemon5.getImg())).fitCenter().into(ivPicture);

                    button1.setBackgroundResource(R.drawable.custom_view_circular_red);
                    button2.setBackgroundResource(R.drawable.custom_view_circular_green);

                    Time();

                    choice();
                }
            });
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Glide.with(getContext()).load(Uri.parse("file:///android_asset/images/"+ pokemon5.getImg())).fitCenter().into(ivPicture);

                    button3.setBackgroundResource(R.drawable.custom_view_circular_red);
                    button2.setBackgroundResource(R.drawable.custom_view_circular_green);

                    Time();

                    choice();
                }
            });
            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Glide.with(getContext()).load(Uri.parse("file:///android_asset/images/"+ pokemon5.getImg())).fitCenter().into(ivPicture);

                    button4.setBackgroundResource(R.drawable.custom_view_circular_red);
                    button2.setBackgroundResource(R.drawable.custom_view_circular_green);

                    Time();

                    choice();
                }
            });


        } else if ( i == 3) {
            final Pokemon pokemon6= DbHeper.getInstance().slectRandomPokemon();
            setImageBlack(pokemon6);
            String u1 = pokemon6.getName();
            button3.setText(u1);
            Pokemon pokemon2= DbHeper.getInstance().slectRandomPokemon();
            button1.setText(pokemon2.getName());
            Pokemon pokemon3= DbHeper.getInstance().slectRandomPokemon();
            button2.setText(pokemon3.getName());
            Pokemon pokemon4= DbHeper.getInstance().slectRandomPokemon();
            button4.setText(pokemon4.getName());

            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Glide.with(getContext()).load(Uri.parse("file:///android_asset/images/"+ pokemon6.getImg())).fitCenter().into(ivPicture);

                    button3.setBackgroundResource(R.drawable.custom_view_circular_green);
                    scoreNow++;
                    score.setText(String.valueOf(scoreNow));
                    Time();

                    choice();
                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Glide.with(getContext()).load(Uri.parse("file:///android_asset/images/"+ pokemon6.getImg())).fitCenter().into(ivPicture);

                    button2.setBackgroundResource(R.drawable.custom_view_circular_red);
                    button3.setBackgroundResource(R.drawable.custom_view_circular_green);

                    Time();

                    choice();
                }
            });
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Glide.with(getContext()).load(Uri.parse("file:///android_asset/images/"+ pokemon6.getImg())).fitCenter().into(ivPicture);

                    button1.setBackgroundResource(R.drawable.custom_view_circular_red);
                    button3.setBackgroundResource(R.drawable.custom_view_circular_green);

                    Time();

                    choice();
                }
            });
            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Glide.with(getContext()).load(Uri.parse("file:///android_asset/images/"+ pokemon6.getImg())).fitCenter().into(ivPicture);

                    button4.setBackgroundResource(R.drawable.custom_view_circular_red);
                    button3.setBackgroundResource(R.drawable.custom_view_circular_green);

                    choice();
                }
            });

        } else  if (i == 4) {
            final Pokemon pokemon7= DbHeper.getInstance().slectRandomPokemon();
            setImageBlack(pokemon7);
            Glide.with(this).load(Uri.parse("file:///android_asset/images/"+ pokemon7.getImg())).fitCenter().into(ivPicture);
            String u1 = pokemon7.getName();
            button4.setText(u1);
            Pokemon pokemon2= DbHeper.getInstance().slectRandomPokemon();
            button1.setText(pokemon2.getName());
            Pokemon pokemon3= DbHeper.getInstance().slectRandomPokemon();
            button3.setText(pokemon3.getName());
            Pokemon pokemon4= DbHeper.getInstance().slectRandomPokemon();
            button2.setText(pokemon4.getName());

            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Glide.with(getContext()).load(Uri.parse("file:///android_asset/images/"+ pokemon7.getImg())).fitCenter().into(ivPicture);

                    button4.setBackgroundResource(R.drawable.custom_view_circular_green);
                    scoreNow++;
                    score.setText(String.valueOf(scoreNow));
                    Time();

                    choice();
                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Glide.with(getContext()).load(Uri.parse("file:///android_asset/images/"+ pokemon7.getImg())).fitCenter().into(ivPicture);

                    button2.setBackgroundResource(R.drawable.custom_view_circular_red);
                    button4.setBackgroundResource(R.drawable.custom_view_circular_green);

                    Time();

                    choice();
                }
            });
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Glide.with(getContext()).load(Uri.parse("file:///android_asset/images/"+ pokemon7.getImg())).fitCenter().into(ivPicture);

                    button3.setBackgroundResource(R.drawable.custom_view_circular_red);
                    button4.setBackgroundResource(R.drawable.custom_view_circular_green);

                    Time();

                    choice();
                }
            });
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Glide.with(getContext()).load(Uri.parse("file:///android_asset/images/"+ pokemon7.getImg())).fitCenter().into(ivPicture);

                    button1.setBackgroundResource(R.drawable.custom_view_circular_red);
                    button4.setBackgroundResource(R.drawable.custom_view_circular_green);

                    Time();

                    choice();
                }
            });

        }

    }


    public void countTime(){
        pbProgess.setProgress(time);
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                pbProgess.setProgress(2000);
//
//                while (pbProgess.getProgress() > 0) {
//                    int s = pbProgess.getProgress();
//                    s--;
//                    try {
//                        Thread.sleep(100);
//                        pbProgess.setProgress(s);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                if (pbProgess.getProgress() == 0) {
//                }
//            }
//        });
//        thread.start();

        countDownTimer = new CountDownTimer(20000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time--;
                pbProgess.setProgress(time);
            }

            @Override
            public void onFinish() {
                ((MainActivity)getActivity()).changeFragment(new ScoreFragment(), true);

            }
        };
        countDownTimer.start();


    }




}
