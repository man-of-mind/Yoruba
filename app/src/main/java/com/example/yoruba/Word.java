package com.example.yoruba;

public class Word {
    private String mDefaultTranslation;
    private String mYorubaTranslation;
    private int mImageResourceId = -1;
    public Word(String defaultTranslation, String yorubaTranslation){
        mDefaultTranslation = defaultTranslation;
        mYorubaTranslation = yorubaTranslation;
    }
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

    public boolean hasImage(){
        return mImageResourceId != -1;
    }

}
