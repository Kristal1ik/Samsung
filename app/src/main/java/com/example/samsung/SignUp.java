package com.example.samsung;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.samsung.BD.RetrofitUserServ;
import com.example.samsung.BD.User;
import com.example.samsung.databinding.FragmentSignupBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SignUp extends Fragment {
    FragmentSignupBinding binding;
    String[] names = new String[10];
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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
                takeName();
                System.out.println(names[0]);
                if(log(username, names)){
//                    переход сделать
//                    if(password.equals(confirm)){
////                        переход
//                    }else{
//                        //                    обработать
//                    }
                }else{
//                    обработать
                }


            }
        });
    }

    public void takeName(){
        RetrofitUserServ.getInstance().getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                assert response.body() != null;
                for (User user: response.body()){
                    String name = user.getName();
                    System.out.println(name);
                    if(name != null)
                        names[0] = name;
                    else {
                        names[0] = "ksefv";
                    }
                    System.out.println(names[0]);
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public Boolean log(String name, String[] names){
        names[0] = "efkl";
        if(names[0].equals(name)){
            return false;
        }else{
            return true;
        }
    }
}