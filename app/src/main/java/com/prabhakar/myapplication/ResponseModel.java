package com.prabhakar.myapplication;

import java.io.Serializable;

public class ResponseModel implements Serializable {
    private String image;
    private String subTitle;
    private String title;

    public String getImage() {
        return image;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getTitle() {
        return title;
    }
}