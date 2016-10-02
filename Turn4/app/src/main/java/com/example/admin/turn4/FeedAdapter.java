package com.example.admin.turn4;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by Admin on 10/2/2016.
 */

public class FeedAdapter extends ArrayAdapter<FeedItem> {
    public FeedAdapter(Context context, int resource, List<FeedItem> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.feed_item, parent, false);
        }
        new FeedViewHolder(convertView).setData(getItem(position));
        return convertView;
    }
}
