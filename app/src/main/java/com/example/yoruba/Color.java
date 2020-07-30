package com.example.yoruba;

public class Color {

    private String mDefaultTranslation;
    private String mYorubaTranslation;
    public Color(String defaultTranslation, String yorubaTranslation){
        mDefaultTranslation = defaultTranslation;
        mYorubaTranslation = yorubaTranslation;
    }
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }
    public String getYorubaTranslation(){
        return mYorubaTranslation;
    }
}
