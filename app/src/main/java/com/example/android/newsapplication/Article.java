package com.example.android.newsapplication;

import java.util.Date;

public class Article {

    private String mPillarName;
    private Date mDate;
    private String mTitle;
    private String mAuthor;
    private String mUrl;

    public Article(String pillarName, Date date, String title, String author, String url) {
        mPillarName = pillarName;
        mDate = date;
        mTitle = title;
        mAuthor = author;
        mUrl = url;
    }

    public String getPilllarName() {
        return mPillarName;
    }

    public Date getDate() {
        return mDate;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getAuthor() { return mAuthor; }

    public String getUrl() {
        return mUrl;
    }
}
