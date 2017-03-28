package com.example.fs.socialcareapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements ClientAdapter.ItemClickCallback {

    private static final String BUNDLE_EXTRAS = "BUNDLE_EXTRAS";
    private static final String EXTRA_TITLE = "EXTRA_TITLE";
    private static final String EXTRA_NAME = "EXTRA_NAME";
    private static final String EXTRA_AREA = "EXTRA_AREA";
    private static final String EXTRA_TIME = "EXTRA_TIME";


    private RecyclerView recView;
    private ClientAdapter adapter;
    private ArrayList listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listData = (ArrayList) Data.getListData();

        recView = (RecyclerView)findViewById(R.id.rec_list);

        recView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ClientAdapter(listData, this);

        recView.setAdapter(adapter);
        adapter.setItemClickCallback(this);

    }

    @Override
    public void onItemClick(int p) {
        ListItem item = (ListItem) listData.get(p);

        Intent i = new Intent(this, ClientActivity.class);

        Bundle extras = new Bundle();
        extras.putString(EXTRA_TITLE, item.getTitle());
        extras.putString(EXTRA_NAME, item.getName());
        extras.putString(EXTRA_AREA, item.getArea());
        extras.putString(EXTRA_TIME, item.getTime());

        i.putExtra(BUNDLE_EXTRAS, extras);

        startActivity(i);
    }
}
