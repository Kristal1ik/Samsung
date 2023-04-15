package com.example.samsung;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.samsung.BD.RetrofitUserServ;
import com.example.samsung.BD.User;
import com.example.samsung.databinding.ActivityMainBinding;
import com.example.samsung.databinding.FragmentLoginBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends Fragment {
    FragmentLoginBinding binding;
    private ArrayList<String> users;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = binding.usernameLogin.getText().toString();
                String password = binding.passwordLogin.getText().toString();
                RetrofitUserServ.getInstance().getUsers().enqueue(new Callback<List<User>>() {
                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                        System.out.println(response.body().toString());
                        for(User i: response.body()){
                            users.add(i.getName());
                        }
                    }
                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t) {
                    }
                });
                if(users.contains(login)){
//                    startActivity(new Intent(Login.this, ProfilePage.class));
                }else{
//                    обработать
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}