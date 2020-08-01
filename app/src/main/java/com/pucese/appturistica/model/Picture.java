package com.pucese.appturistica.model;

public class Picture extends android.graphics.Picture
{
    private String picture;
    private String username;
    private String time;
    private String like_number="0 días";
    private String description;
    private String titleImage;

    public Picture(String picture, String username, String time, String like_number, String titleImage, String description) {
        this.picture = picture;
        this.username = username;
        this.time = time;
        this.like_number = like_number;
        this.description = description;
        this.titleImage = titleImage;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLike_number() {
        return like_number;
    }

    public void setLike_number(String like_number) {
        this.like_number = like_number;
    }

    public String getTitleImage() {
        return titleImage;
    }

    public void setTitleImage(String titleImage) {
        this.titleImage = titleImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}