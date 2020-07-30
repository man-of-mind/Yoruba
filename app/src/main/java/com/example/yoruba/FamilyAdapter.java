package com.example.yoruba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class FamilyAdapter extends ArrayAdapter<Family> {
    public FamilyAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Family> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listView = convertView;
        if(listView == null){
            listView = LayoutInflater.from(getContext()).inflate(R.layout.family_item, parent, false);
        }

        Family currentWord = getItem(position);

        TextView yorubaText = (TextView) listView.findViewById(R.id.yorubaFamily);
        yorubaText.setText(currentWord.getYorubaTranslation());

        TextView nameText = (TextView) listView.findViewById(R.id.englishFamily);
        nameText.setText(currentWord.getDefaultTranslation());
        return listView;
    }
}
