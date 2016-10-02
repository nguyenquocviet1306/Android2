package com.example.admin.turn4;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Admin on 10/2/2016.
 */

public class FeedViewHolder {

    @BindView(R.id.tv_title) public TextView tvTitle;
    @BindView(R.id.tv_time) public TextView tvTime;
    @BindView(R.id.iv_image) public ImageView ivImage;

    public FeedViewHolder(View rootView ){
        ButterKnife.bind(this,rootView);
    }
    public void setData(FeedItem feedItem) {
        tvTitle.setText(feedItem.getTitle());
        tvTime.setText(feedItem.getTime());
        ivImage.setImageResource(feedItem.getImageResId());
    }
}
