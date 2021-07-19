package com.beoks.a2021knu_hackton;

import android.graphics.Bitmap;

/**
 * 공모전,스터디 부모 클래스
 */
public class Content {
    String name;
    Bitmap image;
    int viewCount;

    public Content(String name, Bitmap image, int viewCount) {
        this.name = name;
        this.image = image;
        this.viewCount = viewCount;
    }
}
