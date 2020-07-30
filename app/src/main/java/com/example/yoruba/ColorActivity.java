package com.example.yoruba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        ArrayList<Color> colors = new ArrayList<>();

        colors.add(new Color("White", "fun fun", R.drawable.color_white));
        colors.add(new Color("Black", "dudu", R.drawable.color_black));
        colors.add(new Color("Red", "ejo", R.drawable.color_red));
        colors.add(new Color("Brown", "eta", R.drawable.color_brown));
        colors.add(new Color("Dusty Yellow", "erin", R.drawable.color_dusty_yellow));
        colors.add(new Color("Green", "arun", R.drawable.color_green));
        colors.add(new Color("Gray", "pupa", R.drawable.color_gray));
        colors.add(new Color("Mustard Yellow", "eje", R.drawable.color_mustard_yellow));


        ColorAdapter colorColorAdapter = new ColorAdapter(this, 0, colors);
        ListView listView = (ListView) findViewById(R.id.colorList);
        listView.setAdapter(colorColorAdapter);
    }
}