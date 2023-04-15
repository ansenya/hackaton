package ru.packetSolution.hack.activities;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;

import ru.packetSolution.hack.R;
import ru.packetSolution.hack.databinding.ActivityMainBinding;
import ru.packetSolution.hack.fragments.FragmentAdd;
import ru.packetSolution.hack.fragments.FragmentHome;
import ru.packetSolution.hack.fragments.FragmentUser;
import ru.packetSolution.hack.room.App;
import ru.packetSolution.hack.room.ItemEntity;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    protected boolean firstTime = true;
    ArrayList<ItemEntity> entityArrayList = new ArrayList<>();
    FragmentHome fragmentHome = new FragmentHome(entityArrayList);
    FragmentAdd fragmentAdd = new FragmentAdd(entityArrayList);
    FragmentUser fragmentUser = new FragmentUser();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        new Thread(()->{
            entityArrayList.addAll(App.getDatabase().itemDao().getAll());
        }).start();
        initFragments();
    }

    private void initFragments(){
        getSupportFragmentManager().beginTransaction().
                //replace(binding.start.getId(), fragmentStart).
                replace(binding.home.getId(), fragmentHome).
                replace(binding.add.getId(), fragmentAdd).
                replace(binding.user.getId(), fragmentUser).
                commit();
        makeVisible(binding.home);
        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    makeVisible(binding.home);
                    fragmentHome.notifyAdapter();
                    return true;
                case R.id.add:
                    makeVisible(binding.add);
                    return true;
                case R.id.user:
                    makeVisible(binding.user);
                    return true;
            }
            return false;
        });
    }

    private void makeVisible(FrameLayout id){
        binding.home.setVisibility(View.GONE);
        binding.add.setVisibility(View.GONE);
        binding.search.setVisibility(View.GONE);
        binding.user.setVisibility(View.GONE);
        id.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBackPressed() {
        if (fragmentHome.fullscreen()) {
            fragmentHome.back();
        } else {
            super.onBackPressed();
        }
    }
}