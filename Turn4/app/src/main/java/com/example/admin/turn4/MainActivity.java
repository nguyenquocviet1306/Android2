package com.example.admin.turn4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.lv_feed) public ListView lvFeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupUI();
    }

    private void setupUI() {
        lvFeed.setAdapter(new FeedAdapter(
                this,
                R.layout.feed_item,
                Arrays.asList(FeedItem.ARRAY)
        ));
    }
}
