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
import android.widget.Button;
import android.widget.EditText;

import com.example.samsung.BD.RetrofitUserServ;
import com.example.samsung.BD.User;
import com.example.samsung.databinding.ActivityMainBinding;
import com.example.samsung.databinding.FragmentLoginBinding;

import java.sql.Time;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends Fragment {
    FragmentLoginBinding binding;
    Map<String, String> users;
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
        users  = new HashMap<String, String>();
        users.put("acw", "va;l");
        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeName();
                String login = binding.usernameLogin.getText().toString();
                String password = binding.passwordLogin.getText().toString();
                binding.usernameLogin.setText(""); binding.passwordLogin.setText("");
                System.out.println(password);
                System.out.println(users);
                if(users.get(login) != null){
                    Intent intent = new Intent(v.getContext(), ProfilePage.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(v.getContext(), ProfilePage.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    public void takeName(){
        RetrofitUserServ.getInstance().getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(@NonNull Call<List<User>> call, @NonNull Response<List<User>> response) {
                assert response.body() != null;
                for (User user: response.body()){
                    String name = user.getName();
                    String pas = user.getPassword();
                    Log.d("Name", name);
                    Log.d("Password", pas);
                    users.put(name, pas);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<User>> call,@NonNull Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void button(){

    }

}