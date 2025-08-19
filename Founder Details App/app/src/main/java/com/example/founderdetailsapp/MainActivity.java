package com.example.founderdetailsapp;

import android.os.Bundle;
import android.widget.GridLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item(R.mipmap.google_ceo,"Google"));
        itemList.add(new Item(R.mipmap.microsoft_ceo,"Microsoft"));
        itemList.add(new Item(R.mipmap.nvidia_ceo,"Nvidia"));
        itemList.add(new Item(R.mipmap.amazon_ceo,"Amazon"));
        itemList.add(new Item(R.mipmap.samsung_ceo,"Samsung"));
        itemList.add(new Item(R.mipmap.facebook_ceo,"Facebook"));
        itemList.add(new Item(R.mipmap.apple_ceo,"Apple"));
        itemList.add(new Item(R.mipmap.swiggy_ceo,"Swiggy"));
        itemList.add(new Item(R.mipmap.tcs_ceo,"TCS"));
        itemList.add(new Item(R.mipmap.zomato_ceo,"Zomato"));

        MyAdapter myAdapter = new MyAdapter(this,itemList);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapter);











        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}