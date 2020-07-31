package com.example.yoruba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorResources;
    public WordAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Word> objects, int color) {
        super(context, 0, objects);
        mColorResources = color;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        if (currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceId());
        }
        else{
            imageView.setVisibility(View.GONE);
        }
        TextView yorubaText = (TextView) listItemView.findViewById(R.id.yoruba);
        yorubaText.setText(currentWord.getYorubaTranslation());

        TextView nameText = (TextView) listItemView.findViewById(R.id.english);
        nameText.setText(currentWord.getDefaultTranslation());

        LinearLayout linearLayout = (LinearLayout) listItemView.findViewById(R.id.textLinear);
        int colors = ContextCompat.getColor(getContext(), mColorResources);
        linearLayout.setBackgroundColor(colors);
        return listItemView;
    }
}
