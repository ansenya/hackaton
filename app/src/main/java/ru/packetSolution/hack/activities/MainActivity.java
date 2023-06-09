package ru.packetSolution.hack.activities;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.packetSolution.hack.R;
import ru.packetSolution.hack.data.api.products.ProductsApiService;
import ru.packetSolution.hack.databinding.ActivityMainBinding;
import ru.packetSolution.hack.domain.model.Product;
import ru.packetSolution.hack.fragments.FragmentAdd;
import ru.packetSolution.hack.fragments.FragmentFirstAdd;
import ru.packetSolution.hack.fragments.FragmentHome;
import ru.packetSolution.hack.fragments.FragmentUser;
import ru.packetSolution.hack.room.App;
import ru.packetSolution.hack.room.ItemEntity;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    protected boolean firstTime = true;
    ArrayList<ItemEntity> entityArrayList = new ArrayList<>();
    FragmentHome fragmentHome = new FragmentHome(entityArrayList);
    FragmentFirstAdd fragmentFirstAdd = new FragmentFirstAdd(entityArrayList);
    FragmentUser fragmentUser = new FragmentUser(entityArrayList);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                1);


        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        new Thread(()->{
            entityArrayList.addAll(App.getDatabase().itemDao().getAll());
        }).start();

        ProductsApiService.getInstance().getProducts().enqueue(
                new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                Log.e("MyTag", response.body().toString());
                Log.e("MyTag", response.body().toString());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Log.e("MyTag", t.getMessage());
            }
        });

        initFragments();
    }

    private void initFragments(){
        getSupportFragmentManager().beginTransaction().
                //replace(binding.start.getId(), fragmentStart).
                replace(binding.home.getId(), fragmentHome).
                replace(binding.firstadd.getId(), fragmentFirstAdd).
                replace(binding.user.getId(), fragmentUser).
                commit();
        makeVisible(binding.home);
        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    makeVisible(binding.home);
                    fragmentHome.notifyAdapter();
                    return true;
                case R.id.firstadd:
                    makeVisible(binding.firstadd);
                    return true;
                case R.id.user:
                    makeVisible(binding.user);
                    fragmentUser.notifyAdapter();
                    return true;
            }
            return false;
        });
    }

    private void makeVisible(FrameLayout id){
        binding.home.setVisibility(View.GONE);
        binding.add.setVisibility(View.GONE);
        binding.firstadd.setVisibility(View.GONE);
        binding.search.setVisibility(View.GONE);
        binding.user.setVisibility(View.GONE);
        id.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBackPressed() {
        if (fragmentHome.fullscreen()) {
            fragmentHome.back();
        } else if (false) {
            
        } else {
            super.onBackPressed();
        }
    }

    /*public void editBtn(View view) {
        Intent intent = new Intent(this, EditUserActivity.class);
        startActivity(intent);
    }*/
}