package com.example.yoruba;

public class Word {
    private String mDefaultTranslation;
    private String mYorubaTranslation;
    private int mImageResourceId = -1;
    private int mAudioResourceId;
    public Word(String defaultTranslation, String yorubaTranslation, int audioResourceId){
        mDefaultTranslation = defaultTranslation;
        mYorubaTranslation = yorubaTranslation;
        mAudioResourceId = audioResourceId;
    }
    public Word(String defaultTranslation, String yorubaTranslation, int imageResourceId, int audioResourceId){
        mDefaultTranslation = defaultTranslation;
        mYorubaTranslation = yorubaTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
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

    public int getAudioResourceId(){
        return mAudioResourceId;
    }

    public boolean hasImage(){
        return mImageResourceId != -1;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mYorubaTranslation='" + mYorubaTranslation + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mAudioResourceId=" + mAudioResourceId +
                '}';
    }
}
