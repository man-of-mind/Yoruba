package com.example.yoruba;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorActivity extends AppCompatActivity {
    MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        final ArrayList<Word> colors = new ArrayList<Word>()  ;

        colors.add(new Word("White", "Funfun", R.drawable.color_white,
                R.raw.white));
        colors.add(new Word("Black", "Dudu", R.drawable.color_black,
                R.raw.black));
        colors.add(new Word("Red", "Pupa", R.drawable.color_red,
                R.raw.red));
        colors.add(new Word("Brown", "Àwọ̀ igi", R.drawable.color_brown,
                R.raw.brown));
        colors.add(new Word("Dusty Yellow", "Awo ofeefee",
                R.drawable.color_dusty_yellow, R.raw.awoofeefee));
        colors.add(new Word("Green", "Àwọ̀ Ewé", R.drawable.color_green
        , R.raw.green));
        colors.add(new Word("Gray", "Awọ eeru", R.drawable.color_gray,
                R.raw.gray));
        colors.add(new Word("Mustard Yellow", "ofeefee",
                R.drawable.color_mustard_yellow, R.raw.ofeefee));


        WordAdapter colorColorAdapter = new WordAdapter(this, 0, colors, R.color.color_color);
        ListView listView = (ListView) findViewById(R.id.colorList);
        listView.setAdapter(colorColorAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = colors.get(position);
                mMediaPlayer = MediaPlayer.create(getApplicationContext(), word.getAudioResourceId());
                mMediaPlayer.start();
            }
        });
    }
}