package ru.packetSolution.hack.activities;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import ru.packetSolution.hack.databinding.ActivityEnterBinding;


public class EnterActivity extends AppCompatActivity {

    ActivityEnterBinding binding;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    private final String authorized = "Authorized";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityEnterBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        binding.wrong.setVisibility(View.GONE);
        setContentView(binding.getRoot());

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = preferences.edit();



        init();
    }

    void init() {
        binding.button.setOnClickListener(view -> {
//            if (binding.inputEmail.getInputText().equals("mail@mail.com") &&
//                    binding.inputPassword.getInputText().equals("123456")) {
//                editor.putBoolean(authorized, true);
//                editor.apply();
//                startActivity(new Intent(this, MainActivity.class));
//                finish();
//            } else
//                binding.wrong.setVisibility(View.VISIBLE);
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
        binding.registration.setOnClickListener(view -> {
            startActivity(new Intent(this, RegistrationActivity.class));
        });
    }

}
