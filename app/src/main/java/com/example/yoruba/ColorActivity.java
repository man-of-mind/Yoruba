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

        ArrayList<Word> colors = new ArrayList<Word>()  ;

        colors.add(new Word("White", "Funfun", R.drawable.color_white));
        colors.add(new Word("Black", "Dudu", R.drawable.color_black));
        colors.add(new Word("Red", "Pupa", R.drawable.color_red));
        colors.add(new Word("Brown", "Àwọ̀ igi", R.drawable.color_brown));
        colors.add(new Word("Dusty Yellow", "Awo ofeefee", R.drawable.color_dusty_yellow));
        colors.add(new Word("Green", "Àwọ̀ Ewé", R.drawable.color_green));
        colors.add(new Word("Gray", "Awọ eeru", R.drawable.color_gray));
        colors.add(new Word("Mustard Yellow", "ofeefee", R.drawable.color_mustard_yellow));


        WordAdapter colorColorAdapter = new WordAdapter(this, 0, colors, R.color.color_color);
        ListView listView = (ListView) findViewById(R.id.colorList);
        listView.setAdapter(colorColorAdapter);
    }
}