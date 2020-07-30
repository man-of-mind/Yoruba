package com.example.yoruba;

public class Family {
    private String mDefaultTranslation;
    private String mYorubaTranslation;
    private int mImageResourceId;
    public Family(String defaultTranslation, String yorubaTranslation){
        mDefaultTranslation = defaultTranslation;
        mYorubaTranslation = yorubaTranslation;
    }

    public Family(String defaultTranslation, String yorubaTranslation, int imageResourceId){
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
    public int getImageResourceId(){
        return mImageResourceId;
    }
}
