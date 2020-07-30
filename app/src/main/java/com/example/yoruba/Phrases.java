package com.example.yoruba;

public class Phrases {
    private String mDefaultTranslation;
    private String mYorubaTranslation;
    public Phrases(String defaultTranslation, String yorubaTranslation){
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
