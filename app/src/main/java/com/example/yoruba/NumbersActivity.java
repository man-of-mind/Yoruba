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

        numbers.add(new Word("one", "okan"));
        numbers.add(new Word("two", "eji"));
        numbers.add(new Word("three", "eta"));
        numbers.add(new Word("four", "erin"));
        numbers.add(new Word("five", "arun"));
        numbers.add(new Word("six", "efa"));
        numbers.add(new Word("seven", "eje"));
        numbers.add(new Word("eight", "ejo"));
        numbers.add(new Word("nine", "esan"));
        numbers.add(new Word("ten", "ewa"));


        WordAdapter wordAdapter = new WordAdapter(this, 0, numbers);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(wordAdapter);

    }
}
