package io.szugyi.nytimes.articles;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.szugyi.nytimes.R;
import io.szugyi.nytimes.articles.adapter.ArticleAdapter;
import io.szugyi.nytimes.data.Repository;
import timber.log.Timber;

@EActivity(R.layout.activity_article_list)
public class ArticleListActivity extends DaggerAppCompatActivity {

    @Inject
    Repository repository;

    @Inject
    ArticleAdapter articleAdapter;

    @ViewById
    SwipeRefreshLayout swipeRefreshLayout;

    @ViewById
    RecyclerView articleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadArticles();
    }

    @AfterViews
    void afterViews() {
        articleList.setHasFixedSize(true);
        articleList.setLayoutManager(new LinearLayoutManager(this));
        articleList.setAdapter(articleAdapter);
    }

    private void loadArticles() {
        repository.getArticles()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(articles -> {
                    Timber.d("articles: %d", articles.size());
                    articleAdapter.swapItems(articles);
                }, Timber::e);
    }
}
