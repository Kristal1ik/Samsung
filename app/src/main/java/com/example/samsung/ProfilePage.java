package com.example.samsung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.samsung.databinding.FragmentLoginBinding;

public class ProfilePage extends AppCompatActivity {
    TextView btn, friends;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        btn = (TextView) findViewById(R.id.places);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilePage.this, Map.class);
                startActivity(intent);
            }
        });
        friends = (TextView) findViewById(R.id.friends) ;
        friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilePage.this, RecyclerViewClass.class);
                startActivity(intent);
            }
        });
    }



}