package com.example.yoruba;

public class Color {

    private String mDefaultTranslation;
    private String mYorubaTranslation;
    private int mImageResourceId;
    public Color(String defaultTranslation, String yorubaTranslation, int imageResourceId){
        mDefaultTranslation = defaultTranslation;
        mYorubaTranslation = yorubaTranslation;
        mImageResourceId = imageResourceId;
    }
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }
    public String getYorubaTranslation(){
        return mYorubaTranslation;
    }
    public  int getImageResourceId(){
        return mImageResourceId;
    }
}
