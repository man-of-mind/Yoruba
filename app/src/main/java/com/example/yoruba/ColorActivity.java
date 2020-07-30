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

        colors.add(new Color("White", "okan"));
        colors.add(new Color("Black", "eji"));
        colors.add(new Color("Blue", "eta"));
        colors.add(new Color("Yellow", "erin"));
        colors.add(new Color("Green", "arun"));
        colors.add(new Color("Red", "efa"));
        colors.add(new Color("seven", "eje"));
        colors.add(new Color("eight", "ejo"));
        colors.add(new Color("nine", "esan"));
        colors.add(new Color("ten", "ewa"));


        ColorAdapter colorColorAdapter = new ColorAdapter(this, 0, colors);
        ListView listView = (ListView) findViewById(R.id.colorList);
        listView.setAdapter(colorColorAdapter);
    }
}