package com.example.yoruba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<Word> numbers = new ArrayList<Word>();

        numbers.add(new Word("one", "okan", R.drawable.number_one));
        numbers.add(new Word("two", "meji", R.drawable.number_two));
        numbers.add(new Word("three", "meta", R.drawable.number_three));
        numbers.add(new Word("four", "merin", R.drawable.number_four));
        numbers.add(new Word("five", "marun", R.drawable.number_five));
        numbers.add(new Word("six", "mefa", R.drawable.number_six));
        numbers.add(new Word("seven", "meje", R.drawable.number_seven));
        numbers.add(new Word("eight", "mejo", R.drawable.number_eight));
        numbers.add(new Word("nine", "mesan", R.drawable.number_nine));
        numbers.add(new Word("ten", "mewa", R.drawable.number_ten));


        WordAdapter wordAdapter = new WordAdapter(this, 0, numbers);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(wordAdapter);

    }
}
