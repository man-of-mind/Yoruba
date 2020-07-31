package com.example.yoruba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        ArrayList<Word> families = new ArrayList<Word>();

        families.add(new Word("Mother", "Iya", R.drawable.family_mother));
        families.add(new Word("Father", "Baba", R.drawable.family_father));
        families.add(new Word("Older Brother", "Egbon okunrin", R.drawable.family_older_brother));
        families.add(new Word("Older Sister", "Egbon obinrin", R.drawable.family_older_sister));
        families.add(new Word("Daughter", "Omọbinrin", R.drawable.family_daughter));
        families.add(new Word("Son", "Omọkunrin", R.drawable.family_son));
        families.add(new Word("Grandfather", "Baba agba", R.drawable.family_grandfather));
        families.add(new Word("Grandmother", "Iya agba", R.drawable.family_grandmother));
        families.add(new Word("Younger Brother", "Aburo okunrin", R.drawable.family_younger_brother));
        families.add(new Word("Younger Sister", "Aburo obinrin", R.drawable.family_younger_sister));


        WordAdapter familyAdapter = new WordAdapter(this, 0, families, R.color.family_color);
        ListView listView = (ListView) findViewById(R.id.family);
        listView.setAdapter(familyAdapter);
    }
}