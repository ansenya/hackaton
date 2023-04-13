package ru.packetSolution.hack.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import ru.packetSolution.hack.activities.MainActivity;
import ru.packetSolution.hack.databinding.ActivityRegistartionBinding;

public class RegistrationActivity extends AppCompatActivity {

    ActivityRegistartionBinding binding;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    private final String authorized = "Authorized";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityRegistartionBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = preferences.edit();
        init();
    }


    private void init() {
        binding.button.setOnClickListener(view -> {
//            if (binding.inputEmail.getInputText().contains("@") &&
//                    binding.inputPassword.getInputText().equals(binding.inputRepeatPassword.getInputText()) &&
//                    binding.checkbox.isChecked()){
//
//                editor.putBoolean(authorized, true);
//                editor.apply();
//
//                startActivity(new Intent(this, MainActivity.class));
//                finish();
//            } else {
//                binding.wrong.setVisibility(View.VISIBLE);
//            }
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
        binding.switcher.setOnClickListener(view -> {
            onBackPressed();
        });
    }

}
