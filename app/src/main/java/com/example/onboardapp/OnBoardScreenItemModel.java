package com.example.onboardapp;

public class OnBoardScreenItemModel {

    String heading ;
    String sub_heading;
    int imageId;

    public OnBoardScreenItemModel(String heading, String sub_heading, int imageId) {
        this.heading = heading;
        this.sub_heading = sub_heading;
        this.imageId = imageId;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getSub_heading() {
        return sub_heading;
    }

    public void setSub_heading(String sub_heading) {
        this.sub_heading = sub_heading;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
