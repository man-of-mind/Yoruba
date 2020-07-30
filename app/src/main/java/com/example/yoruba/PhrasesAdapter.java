package com.example.yoruba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PhrasesAdapter extends ArrayAdapter<Phrases> {
    public PhrasesAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Phrases> objects) {
        super(context, 0, objects);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listView = convertView;
        if(listView == null){
            listView = LayoutInflater.from(getContext()).inflate(R.layout.phrase_item, parent, false);
        }

        Phrases currentWord = getItem(position);

        TextView yorubaText = (TextView) listView.findViewById(R.id.yorubaPhrases);
        yorubaText.setText(currentWord.getYorubaTranslation());

        TextView nameText = (TextView) listView.findViewById(R.id.englishPhrases);
        nameText.setText(currentWord.getDefaultTranslation());
        return listView;
    }
}
