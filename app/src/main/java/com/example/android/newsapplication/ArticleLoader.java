package com.example.android.newsapplication;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;
public class ArticleLoader extends AsyncTaskLoader<List<Article>> {
    private static final String LOG_TAG = ArticleLoader.class.getName();

    private String mUrl;

    /**
     * Constructs a new ArticleLoader
     *
     * @param context of the activity
     * @param url to load data from
     */
    public ArticleLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Article> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        List<Article> articles = QueryUtils.fetchArticles(mUrl);
        return articles;
    }
}
