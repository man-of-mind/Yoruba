package com.example.yoruba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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
            listView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Color currentWord = getItem(position);
        ImageView imageView = (ImageView) listView.findViewById(R.id.image);
        imageView.setImageResource(currentWord.getImageResourceId());

        TextView yorubaText = (TextView) listView.findViewById(R.id.yoruba);
        yorubaText.setText(currentWord.getYorubaTranslation());

        TextView nameText = (TextView) listView.findViewById(R.id.english);
        nameText.setText(currentWord.getDefaultTranslation());
        return listView;
    }
}
