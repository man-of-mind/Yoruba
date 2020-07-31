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

        ArrayList<Word> phrases = new ArrayList<Word>();

        phrases.add(new Word("Good morning", "Ekaaro"));
        phrases.add(new Word("How are you?", "Bawo ni o se wa?"));
        phrases.add(new Word("Where are you going?", "Nibo ni iwon lo?"));
        phrases.add(new Word("What is your name?", "Ki 'ni oruko re?"));
        phrases.add(new Word("My name is...", "Orukọ mi ni..."));
        phrases.add(new Word("I am feeling good", "Ara mi ya"));
        phrases.add(new Word("Are you coming?", "Se o n bọ?"));
        phrases.add(new Word("Yes, I'm coming", "Bẹẹni, mo n bọ"));



        WordAdapter phrasesAdapter = new WordAdapter(this, 0, phrases, R.color.phrases_color);
        ListView listView = (ListView) findViewById(R.id.phrases);
        listView.setAdapter(phrasesAdapter);
    }
}