package com.example.samsung;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.samsung.BD.RetrofitUserServ;
import com.example.samsung.BD.User;
import com.example.samsung.databinding.FragmentSignupBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;


public class SignUp extends Fragment {
    FragmentSignupBinding binding;
    Map<String, String> users = new HashMap<String, String>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        takeName();
        binding = FragmentSignupBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = binding.usernameSignup.getText().toString();
                String password = binding.passwordSignup.getText().toString();
                String confirm = binding.againPasswordSignup.getText().toString();
                binding.usernameSignup.setText(""); binding.passwordSignup.setText(""); binding.againPasswordSignup.setText("");
                if(username != null && password != null){
                    if (users.containsKey(username)){
//                        ТАКОЙ УЖЕ ЕСТЬ ИДИ ЗАХОДИ
                    } else if (password.equals(confirm)){
                        regestrated(username, password);
//                        Переход на логин
                    }else {
//                        РУКОЖОП
                    }
                }else{
//               РУКОЖОП
                }
            }
        });
    }

    public void takeName(){
        RetrofitUserServ.getInstance().getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(@NonNull Call<List<User>> call, @NonNull Response<List<User>> response) {
                assert response.body() != null;
                for (User user: response.body()){
                    String name = user.getName();
                    String pas = user.getPassword();
                    users.put(name, pas);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<User>> call,@NonNull Throwable t) {
                Log.d("AAAAAAAA", "AAAAAAAAAAAAAAAAAA");
            }
        });
    }

    public void regestrated(String name, String passsword){
        RetrofitUserServ.getInstance().add(new User(0, name, passsword, null)).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d("СОЗДААААААААЛ", "СОЗДААААААААЛ");
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("НЕЕЕЕЕЕЕ СОЗДААААААААЛ", "НЕЕЕЕЕЕЕ СОЗДААААААААЛ");
            }
        });
    }
}