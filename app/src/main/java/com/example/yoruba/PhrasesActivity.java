package com.example.yoruba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        ArrayList<Phrases> phrases = new ArrayList<Phrases>();

        phrases.add(new Phrases("Good morning", "ekaro"));
        phrases.add(new Phrases("How are you?", "bawo nii"));
        phrases.add(new Phrases("Sister", "eta"));
        phrases.add(new Phrases("Brother", "erin"));
        phrases.add(new Phrases("Green", "arun"));
        phrases.add(new Phrases("Red", "efa"));
        phrases.add(new Phrases("seven", "eje"));
        phrases.add(new Phrases("eight", "ejo"));
        phrases.add(new Phrases("nine", "esan"));
        phrases.add(new Phrases("ten", "ewa"));


        PhrasesAdapter phrasesAdapter = new PhrasesAdapter(this, 0, phrases);
        ListView listView = (ListView) findViewById(R.id.phrases);
        listView.setAdapter(phrasesAdapter);
    }
}