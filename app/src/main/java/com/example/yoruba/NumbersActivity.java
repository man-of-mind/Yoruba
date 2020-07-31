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

        numbers.add(new Word("One", "Okan", R.drawable.number_one));
        numbers.add(new Word("Two", "Meji", R.drawable.number_two));
        numbers.add(new Word("Three", "Mẹta", R.drawable.number_three));
        numbers.add(new Word("Four", "Mẹrin", R.drawable.number_four));
        numbers.add(new Word("Five", "Marun", R.drawable.number_five));
        numbers.add(new Word("Six", "Mefa", R.drawable.number_six));
        numbers.add(new Word("Seven", "Meje", R.drawable.number_seven));
        numbers.add(new Word("Eight", "Mẹjọ", R.drawable.number_eight));
        numbers.add(new Word("Nine", "Mẹsan", R.drawable.number_nine));
        numbers.add(new Word("Ten", "Mẹwa", R.drawable.number_ten));


        WordAdapter wordAdapter = new WordAdapter(this, 0, numbers, R.color.number_color);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(wordAdapter);

    }
}
