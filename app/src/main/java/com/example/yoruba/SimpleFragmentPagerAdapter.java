package com.example.yoruba;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;
    public SimpleFragmentPagerAdapter(@NonNull FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return  new NumbersFragment();
        }
        else if (position == 1){
            return new FamilyFragment();
        }
        else if(position == 2){
            return new ColorFragment();
        }
        else {
            return new PhrasesFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0){
            return mContext.getString(R.string.numbers);
        }
        else if(position == 1){
            return mContext.getString(R.string.family_members);
        }
        else if (position == 2){
            return mContext.getString(R.string.colors);
        }
        else{
            return mContext.getString(R.string.phrases);
        }
    }
}
