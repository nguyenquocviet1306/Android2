package com.example.admin.tumblelog.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.tumblelog.R;
import com.example.admin.tumblelog.models.Post;
import com.example.admin.tumblelog.viewholders.PostViewHolder;

/**
 * Created by Admin on 10/25/2016.
 */

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {
    // Create new
    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 1 : Inflate View ( Căng view)
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_post,parent,false);

        // 2 : Create View Holder
        PostViewHolder postViewHolder = new PostViewHolder(itemView);

        return postViewHolder;
    }
    // Update
    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        // Model
        Post post = Post.list.get(position);
        // Bind
        holder.bind(post);
    }
    // Get count
    @Override
    public int getItemCount() {
        return Post.list.size();
    }
}
