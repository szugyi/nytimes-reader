package io.szugyi.nytimes.articles;

import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import dagger.android.support.DaggerAppCompatActivity;
import io.szugyi.nytimes.R;

@EActivity(R.layout.activity_article_details)
public class ArticleDetailsActivity extends DaggerAppCompatActivity {

    @Extra
    String url;

    @ViewById
    WebView webView;

    @AfterViews
    void afterViews() {
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }
}
