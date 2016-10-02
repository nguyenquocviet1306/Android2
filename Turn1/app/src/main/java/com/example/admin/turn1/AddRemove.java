package com.example.admin.turn1;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Admin on 10/2/2016.
 */

public class AddRemove extends LinearLayout {
    private int numberNew;

    public int getNumberNew() {
        return numberNew;
    }

    public void setNumberNew(int numberNew) {
        this.numberNew = numberNew;
        updateUI();
    }

    @BindView(R.id.iv_add) public ImageView ivAdd;
    @BindView(R.id.iv_remove) public ImageView ivRemove;
    @BindView(R.id.tv_number) public TextView tvNumber;

    public AddRemove(Context context) {
        super(context);
        initFromContext(context);
    }

    public AddRemove(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFromContext(context);
    }

    public AddRemove(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initFromContext(context);
    }
    private void updateUI(){

        tvNumber.setText(String.format("%s",numberNew));
    }
    void initFromContext(Context context){
        View rootView = inflate(context,R.layout.add_remove,this);
        ButterKnife.bind(this,rootView);
        updateUI();
        addListener();
  }
    private void addListener(){
        ;
        ivAdd.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                numberNew = numberNew +1;
                updateUI();
            }
        });
        ivRemove.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                numberNew = numberNew -1;
                updateUI();
            }
        });
    }
}
