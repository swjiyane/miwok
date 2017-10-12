package com.example.codetribe.miwok;

/**
 * Created by CodeTribe on 6/7/2017.
 */


public class Word{

    private String mDefaultTranslation;
    private  String mMiwokTranslation;
    private int mImageResourcedId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mAudioResourceId;

     public  Word(String defaultTranslation, String miwokTranslation, int audioResourceId)
     {
         mDefaultTranslation = defaultTranslation;
         mMiwokTranslation = miwokTranslation;
         mAudioResourceId = audioResourceId;
     }


    public Word(String defaultTranslation, String miwokTranslation, int imageResourcedId, int audioResourceId)
    {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourcedId = imageResourcedId;
        mAudioResourceId = audioResourceId;
    }

    public String getmDefaultTranslation()
    {
        return mDefaultTranslation;
    }

    public String getmMiwokTranslation()
    {
        return mMiwokTranslation;
    }

    public int getmImageResourcedId()
    {
        return mImageResourcedId;
    }

    public boolean hasImage()

    {
        return mImageResourcedId != NO_IMAGE_PROVIDED;
    }

    public int getmAudioResourceId() {return mAudioResourceId;}
}