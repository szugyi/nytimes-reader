package io.szugyi.nytimes.articles;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import io.szugyi.nytimes.R;
import io.szugyi.nytimes.articles.adapter.ArticleAdapter;
import io.szugyi.nytimes.data.model.Article;
import io.szugyi.nytimes.util.ItemClickSupport;

@EActivity(R.layout.activity_article_list)
public class ArticleListActivity extends DaggerAppCompatActivity implements ArticlesContract.View {

    @Inject
    ArticlesContract.Presenter articlesPresenter;

    @Inject
    ArticleAdapter articleAdapter;

    @ViewById
    SwipeRefreshLayout swipeRefreshLayout;

    @ViewById
    RecyclerView articleList;

    @AfterViews
    void afterViews() {
        articleList.setHasFixedSize(true);
        articleList.setLayoutManager(new LinearLayoutManager(this));
        articleList.setAdapter(articleAdapter);

        ItemClickSupport.addTo(articleList)
                .setOnItemClickListener((recyclerView, position, v) -> {
                    Article article = articleAdapter.getItemAt(position);
                    articlesPresenter.openArticleDetails(article);
                });

        swipeRefreshLayout.setOnRefreshListener(() -> articlesPresenter.loadArticles());

        articlesPresenter.takeView(this);
    }

    @Override
    protected void onDestroy() {
        ItemClickSupport.removeFrom(articleList);
        articlesPresenter.dropView();

        super.onDestroy();
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        swipeRefreshLayout.setRefreshing(active);
    }

    @Override
    public void showArticles(List<Article> articles) {
        articleAdapter.swapItems(articles);
    }

    @Override
    public void showArticleDetails(String url) {
        ArticleDetailsActivityImpl.intent(this)
                .url(url)
                .start();
    }
}
