package com.techapp.techepilogued;

import android.app.LauncherActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.techapp.techepilogued.adapter.RssFeedAdapter;
import com.techapp.techepilogued.model.RssFeed;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        loadRss("www.techepilogued.com/feed");

        return true;
    }

    private void loadRss(String url) {
        try {
            new RetrieveFeedTask(this).execute(url);
        } catch (Exception e) {
            Toast.makeText(this, "Exception: " + e.toString(), Toast.LENGTH_LONG).show();
        }

    }

    public void setFeed(List<RssFeed> feed) {
        RecyclerView noteRecycler = findViewById(R.id.feed);
        RssFeedAdapter adapter = new RssFeedAdapter(feed);
        noteRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        noteRecycler.setItemAnimator(new DefaultItemAnimator());
        noteRecycler.setAdapter(adapter);
        noteRecycler.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
