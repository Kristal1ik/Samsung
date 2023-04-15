package com.example.samsung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.samsung.databinding.FragmentLoginBinding;

public class ProfilePage extends AppCompatActivity {
    FragmentLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
    }
    public void get_places(View view) {
        Intent intent = new Intent(ProfilePage.this, Map.class);
        startActivity(intent);
    }

}