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

        families.add(new Family("Mother", "okan"));
        families.add(new Family("Father", "eji"));
        families.add(new Family("Sister", "eta"));
        families.add(new Family("Brother", "erin"));
        families.add(new Family("Green", "arun"));
        families.add(new Family("Red", "efa"));
        families.add(new Family("seven", "eje"));
        families.add(new Family("eight", "ejo"));
        families.add(new Family("nine", "esan"));
        families.add(new Family("ten", "ewa"));


        FamilyAdapter familyAdapter = new FamilyAdapter(this, 0, families);
        ListView listView = (ListView) findViewById(R.id.family);
        listView.setAdapter(familyAdapter);
    }
}