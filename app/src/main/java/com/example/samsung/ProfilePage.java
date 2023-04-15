package com.example.samsung;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.samsung.databinding.FragmentLoginBinding;

public class ProfilePage extends AppCompatActivity {
    FragmentLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
    }
}