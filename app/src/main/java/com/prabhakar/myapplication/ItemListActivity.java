package com.prabhakar.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<ResponseModel> item;
    private ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        initViews();
        buildList();
        setAdapter();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
    }

    private void buildList() {
        //testing
        item = new ArrayList<>();
        item.add(new ResponseModel());
        item.add(new ResponseModel());
        item.add(new ResponseModel());
        item.add(new ResponseModel());
    }

    private void setAdapter() {
        itemAdapter = new ItemAdapter(item);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(itemAdapter);
    }
}