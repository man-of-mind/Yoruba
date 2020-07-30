package com.example.yoruba;

public class Family {
    private String mDefaultTranslation;
    private String mYorubaTranslation;
    public Family(String defaultTranslation, String yorubaTranslation){
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
