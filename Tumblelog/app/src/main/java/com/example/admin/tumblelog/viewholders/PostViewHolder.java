package com.example.admin.tumblelog.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.admin.tumblelog.R;
import com.example.admin.tumblelog.models.Post;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Admin on 10/25/2016.
 */

public class PostViewHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.tv_title)
    public TextView tvTitle;

    @BindView(R.id.tv_content)
    public TextView tvContent;

    public PostViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
    public void bind(Post post){
        tvTitle.setText(post.getTitle());
        tvContent.setText(post.getContent());
    }
}
