package ru.packetSolution.hack.activities;

import static ru.packetSolution.hack.R.id.viewpager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import ru.packetSolution.hack.R;
import ru.packetSolution.hack.adapters.ViewPager2Adapter;

public class StartActivity extends AppCompatActivity {
    private ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        viewPager2 = findViewById(viewpager2);

        ViewPager2Adapter viewPager2Adapter = new ViewPager2Adapter(this);

        viewPager2.setAdapter(viewPager2Adapter);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
        DotsIndicator dotsIndicator = (DotsIndicator) findViewById(R.id.dots_indicator2);
        dotsIndicator.attachTo(viewPager2);

        Button btn = findViewById(R.id.homebtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}