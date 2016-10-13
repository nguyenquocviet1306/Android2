package com.example.admin.lapnew06.adapters;

import android.content.ClipData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.admin.lapnew06.R;
import com.example.admin.lapnew06.jsonmodels.JsonModels;

import java.util.List;

/**
 * Created by Admin on 10/13/2016.
 */

public class JsonAdapter extends ArrayAdapter<JsonModels> {
    public JsonAdapter(Context context, int resource, JsonModels[] objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
        convertView = layoutInflater.inflate(R.layout.item,parent,false);

        JsonModels jsonModels = getItem(position);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
        TextView tvBody = (TextView) convertView.findViewById(R.id.tv_body);
        TextView tvUserId = (TextView) convertView.findViewById(R.id.tv_user_id);

        tvTitle.setText(jsonModels.getTitle());
        tvBody.setText(jsonModels.getBody());
        tvUserId.setText(jsonModels.getUserId());
        return convertView;
    }
}
