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

        ArrayList<Family> families = new ArrayList<Family>();

        families.add(new Family("Mother", "iya", R.drawable.family_mother));
        families.add(new Family("Father", "baba", R.drawable.family_father));
        families.add(new Family("Older Brother", "egbon okunrin", R.drawable.family_older_brother));
        families.add(new Family("Older Sister", "egbon obinrin", R.drawable.family_older_sister));
        families.add(new Family("Daughter", "omo obinrin", R.drawable.family_daughter));
        families.add(new Family("Son", "omo okunrin", R.drawable.family_son));
        families.add(new Family("Grandfather", "eje", R.drawable.family_grandfather));
        families.add(new Family("Grandmother", "ejo", R.drawable.family_grandmother));
        families.add(new Family("Younger Brother", "aburo okunrin", R.drawable.family_younger_brother));
        families.add(new Family("Younger Sister", "aburo obinrin", R.drawable.family_younger_sister));


        FamilyAdapter familyAdapter = new FamilyAdapter(this, 0, families);
        ListView listView = (ListView) findViewById(R.id.family);
        listView.setAdapter(familyAdapter);
    }
}