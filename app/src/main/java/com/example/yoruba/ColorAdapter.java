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

public class ColorAdapter extends ArrayAdapter<Color> {
    public ColorAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Color> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listView = convertView;
        if(listView == null){
            listView = LayoutInflater.from(getContext()).inflate(R.layout.color_item, parent, false);
        }

        Color currentWord = getItem(position);

        TextView yorubaText = (TextView) listView.findViewById(R.id.yorubaColor);
        yorubaText.setText(currentWord.getYorubaTranslation());

        TextView nameText = (TextView) listView.findViewById(R.id.englishColor);
        nameText.setText(currentWord.getDefaultTranslation());
        return listView;
    }
}
