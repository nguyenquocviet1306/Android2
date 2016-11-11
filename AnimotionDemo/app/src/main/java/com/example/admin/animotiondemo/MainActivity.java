package com.example.admin.animotiondemo;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    private View vItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vItem = findViewById(R.id.v_item);

        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.anim_enter,R.anim.anim_exit)
                .replace(R.id.fl_container,new InFragment())
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu,menu);
        menu.findItem(R.id.mni_animate).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Log.d(TAG, "onMenuItemClick");
//                translate();
//                translateByXML();
//                rotateByXML();
//                rotate();
//                scale();
//                alpha();
//                alphabyXML();

//                scaleByXML();
                getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.anim.anim_enter,R.anim.anim_exit)
                        .replace(R.id.fl_container,new OutFragment())
                        .commit();
                return false;
            }
        });
        return true;
    }

    void translate() {
        // 1 : Create animation
        TranslateAnimation translateAnimation = new TranslateAnimation(
                0, 200, // X
                0, 0 // Y
        );

        translateAnimation.setDuration(300);

        translateAnimation.setFillAfter(true);

        translateAnimation.setInterpolator(new LinearInterpolator());
        // 2 : Animate
        vItem.startAnimation(translateAnimation);
    }

    void translateByXML(){
         // 1 : Load animation By XML
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.move_to_right);
        vItem.startAnimation(animation);
    }

    void rotate(){
        // 1 : Create animation
        RotateAnimation rotateAnimation = new RotateAnimation(
                0,360,
                Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,0.5f
        );

        rotateAnimation.setRepeatCount(Animation.INFINITE);
        rotateAnimation.setInterpolator(new LinearInterpolator());

        rotateAnimation.setDuration(3000);
        rotateAnimation.setFillAfter(true);

        // 2 : Animate
        vItem.startAnimation(rotateAnimation);
    }

    void rotateByXML(){
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.anim_rotate_forever);
        vItem.startAnimation(animation);

    }

    void scale(){
        ScaleAnimation scaleAnimation = new ScaleAnimation(100,100,100,100,50,50,0,0);
        scaleAnimation.setDuration(300);
        scaleAnimation.setInterpolator(new LinearInterpolator());
        vItem.startAnimation(scaleAnimation);
    }
    void scaleByXML(){
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.anim_scale);
        vItem.startAnimation(animation);
    }
    void alpha(){
        AlphaAnimation alaphaAnimation = new AlphaAnimation(1,0);
        alaphaAnimation.setDuration(300);
        alaphaAnimation.setFillAfter(true);
        alaphaAnimation.setInterpolator(new LinearInterpolator());
        vItem.startAnimation(alaphaAnimation);
    }
    void alphabyXML(){
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.anim_alpha);
        vItem.startAnimation(animation);
    }
}
