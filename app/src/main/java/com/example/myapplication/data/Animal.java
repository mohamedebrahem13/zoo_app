package com.example.myapplication.data;

public class Animal {

    /** Audio resource ID for the word */
    private int mAudioResourceId;
    private int arabicsound;
    private String details ;



    public int getArabicsound() {
        return arabicsound;
    }

    public void setArabicsound(int arabicsound) {
        this.arabicsound = arabicsound;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }



    /** Image resource ID for the word */
    private int mImageResourceId;

    private static final int NO_IMAGE_PROVIDED = -1;


    public int getmAudioResourceId() {
        return mAudioResourceId;
    }


    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }


    public Animal(int mAudioResourceId, int mImageResourceId,String details,int arabicsound) {
        setArabicsound(arabicsound);
        setDetails(details);
        this.mAudioResourceId = mAudioResourceId;
        this.mImageResourceId = mImageResourceId;

    }
}
