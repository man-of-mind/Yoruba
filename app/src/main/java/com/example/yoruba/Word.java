package com.example.yoruba;

public class Word {
    private String mDefaultTranslation;
    private String mYorubaTranslation;
    private int mImageResourceId;
    public Word(String defaultTranslation, String yorubaTranslation, int resourceId){
        mDefaultTranslation = defaultTranslation;
        mYorubaTranslation = yorubaTranslation;
        mImageResourceId = resourceId;
    }
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }
    public String getYorubaTranslation(){
        return mYorubaTranslation;
    }

    public int getImageResourceId(){
        return mImageResourceId;
    }

}
