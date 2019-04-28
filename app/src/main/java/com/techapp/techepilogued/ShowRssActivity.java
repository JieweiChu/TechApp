package com.techapp.techepilogued;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.TextView;

import com.techapp.techepilogued.model.RssFeed;

public class ShowRssActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_feed);
        swipeRefreshLayout = findViewById(R.id.swipeToRefresh);
/*        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Bundle extras = getIntent().getExtras();
                if (extras != null) {
                    RssFeed rss = (RssFeed) extras.get("rss");
                    ((WebView)findViewById(R.id.descriptionText)).loadUrl(rss.getLink());
                    ((TextView)findViewById(R.id.dateText)).setText(rss.getPubDate().toString());
                }
                swipeRefreshLayout.setRefreshing(false);
            }
        });*/
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            RssFeed rss = (RssFeed) extras.get("rss");
            ((WebView)findViewById(R.id.descriptionText)).loadUrl(rss.getLink());
            ((TextView)findViewById(R.id.dateText)).setText(rss.getPubDate().toString());
        }

    }
}
