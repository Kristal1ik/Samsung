package com.example.samsung;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewClass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_class);

        RecyclerView recyclerView = findViewById(R.id.rv);

        List<com.example.samsung.Item> items = new ArrayList<com.example.samsung.Item>();
        items.add(new com.example.samsung.Item("John wick","john.wick@email.com",R.drawable.a));
        items.add(new com.example.samsung.Item("Robert j","robert.j@email.com",R.drawable.b));
        items.add(new com.example.samsung.Item("James Gunn","james.gunn@email.com",R.drawable.c));
        items.add(new com.example.samsung.Item("Ricky tales","rickey.tales@email.com",R.drawable.d));
        items.add(new com.example.samsung.Item("Micky mose","mickey.mouse@email.com",R.drawable.e));
        items.add(new com.example.samsung.Item("Pick War","pick.war@email.com",R.drawable.f));
        items.add(new com.example.samsung.Item("Leg piece","leg.piece@email.com",R.drawable.g));
        items.add(new com.example.samsung.Item("Apple Mac","apple.mac@email.com",R.drawable.g));
        items.add(new com.example.samsung.Item("John wick","john.wick@email.com",R.drawable.a));
        items.add(new com.example.samsung.Item("Robert j","robert.j@email.com",R.drawable.b));
        items.add(new com.example.samsung.Item("James Gunn","james.gunn@email.com",R.drawable.c));
        items.add(new com.example.samsung.Item("Ricky tales","rickey.tales@email.com",R.drawable.d));
        items.add(new com.example.samsung.Item("Micky mose","mickey.mouse@email.com",R.drawable.e));
        items.add(new com.example.samsung.Item("Pick War","pick.war@email.com",R.drawable.f));
        items.add(new com.example.samsung.Item("Leg piece","leg.piece@email.com",R.drawable.g));
        items.add(new com.example.samsung.Item("Apple Mac","apple.mac@email.com",R.drawable.g));




        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),items));

    }
}