package ru.packetSolution.hack.activities;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationBarView;

import ru.packetSolution.hack.R;
import ru.packetSolution.hack.databinding.ActivityMainBinding;
import ru.packetSolution.hack.fragments.FragmentAdd;
import ru.packetSolution.hack.fragments.FragmentHome;
import ru.packetSolution.hack.fragments.FragmentSearch;
import ru.packetSolution.hack.fragments.FragmentUser;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FragmentHome fragmentHome = new FragmentHome();
    FragmentAdd fragmentAdd = new FragmentAdd();
    FragmentSearch fragmentSearch = new FragmentSearch();
    FragmentUser fragmentUser = new FragmentUser();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        initFragments();
    }

    private void initFragments(){
        getSupportFragmentManager().beginTransaction().
                replace(binding.home.getId(), fragmentHome).
                replace(binding.search.getId(), fragmentSearch).
                replace(binding.add.getId(), fragmentAdd).
                replace(binding.user.getId(), fragmentUser).
                commit();
        makeVisible(binding.home);
        binding.bottomNavigation.setOnItemSelectedListener(item ->
        {
            switch (item.getItemId()){
                case R.id.home:
                    makeVisible(binding.home);
                    return true;
                case R.id.search:
                    makeVisible(binding.search);
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
}