package com.example.yoruba;

public class Word {
    private String mDefaultTranslation;
    private String mYorubaTranslation;
    public Word(String defaultTranslation, String yorubaTranslation){
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
