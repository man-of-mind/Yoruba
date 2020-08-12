package com.example.yoruba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(adapter);

        TabLayout tab = (TabLayout) findViewById(R.id.tab_layout);
        tab.setupWithViewPager(viewPager);
    }
}