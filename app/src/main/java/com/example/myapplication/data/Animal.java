package com.example.myapplication.data;

public class Animal {

    /** Audio resource ID for the word */
    private int mAudioResourceId;


    private String animalname;

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    private String details ;
    public String getAnimalname() {
        return animalname;
    }

    /** Image resource ID for the word */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

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


    public Animal(int mAudioResourceId, String animalname, int mImageResourceId,String details) {
        this.mAudioResourceId = mAudioResourceId;
        this.animalname = animalname;
        this.mImageResourceId = mImageResourceId;
        this.details=details;
    }
}
