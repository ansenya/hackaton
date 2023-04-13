package ru.packetSolution.hack.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;

import ru.packetSolution.hack.adapters.ViewPager2Adapter;
import ru.packetSolution.hack.databinding.ActivityStartBinding;

public class StartActivity extends AppCompatActivity {
    private ActivityStartBinding binding;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = preferences.edit();


        if((ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)) {
            ActivityCompat.requestPermissions(this,
                    new String[ ] {Manifest.permission.READ_EXTERNAL_STORAGE},
                    1);
        }

        if (!preferences.contains("Authorized")) {
            editor.putBoolean("Authorized", false).commit();
        } else if (preferences.getBoolean("Authorized", true)) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }

        init();


    }

    private void init() {
        binding.viewpager2.setAdapter(new ViewPager2Adapter(this));
        binding.dotsIndicator2.attachTo(binding.viewpager2);
        binding.homebtn.setOnClickListener(v -> {
            startActivity(new Intent(this, EnterActivity.class));
            finish();
        });
    }
}