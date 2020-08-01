package com.example.yoruba;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        final ArrayList<Word> numbers = new ArrayList<Word>();

        numbers.add(new Word("One", "Okan", R.drawable.number_one,
                R.raw.okan));
        numbers.add(new Word("Two", "Meji", R.drawable.number_two,
                R.raw.number2));
        numbers.add(new Word("Three", "Mẹta", R.drawable.number_three,
                R.raw.number3));
        numbers.add(new Word("Four", "Mẹrin", R.drawable.number_four,
                R.raw.number4));
        numbers.add(new Word("Five", "Marun", R.drawable.number_five,
                R.raw.number5));
        numbers.add(new Word("Six", "Mefa", R.drawable.number_six,
                R.raw.number6));
        numbers.add(new Word("Seven", "Meje", R.drawable.number_seven,
                R.raw.number7));
        numbers.add(new Word("Eight", "Mẹjọ", R.drawable.number_eight,
                R.raw.number8));
        numbers.add(new Word("Nine", "Mẹsan", R.drawable.number_nine,
                R.raw.number9));
        numbers.add(new Word("Ten", "Mẹwa", R.drawable.number_ten,
                R.raw.number10));


        WordAdapter wordAdapter = new WordAdapter(this, 0, numbers, R.color.number_color);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(wordAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = numbers.get(position);
                mMediaPlayer = MediaPlayer.create(getApplicationContext(), word.getAudioResourceId());
                mMediaPlayer.start();
            }
        });
    }
}
