package io.szugyi.nytimes.articles;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.szugyi.nytimes.data.Repository;
import io.szugyi.nytimes.data.model.Article;
import timber.log.Timber;

public class ArticlesPresenter implements ArticlesContract.Presenter {

    private final Repository repository;

    private CompositeDisposable disposables = new CompositeDisposable();

    @Nullable
    private ArticlesContract.View articlesView;

    @Inject
    public ArticlesPresenter(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void takeView(ArticlesContract.View view) {
        this.articlesView = view;
        loadArticles();
    }

    @Override
    public void dropView() {
        articlesView = null;
        disposables.clear();
    }

    @Override
    public void loadArticles() {
        repository.getArticles()
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> notifyLoadingStateChange(true))
                .doOnTerminate(() -> notifyLoadingStateChange(false))
                .subscribe(articles -> {
                    if (articlesView == null) {
                        return;
                    }

                    articlesView.showArticles(articles);
                }, Timber::e);
    }

    @Override
    public void openArticleDetails(@NonNull Article article) {
        if (articlesView == null) {
            return;
        }

        articlesView.showArticleDetails(article.getUrl());
    }

    private void notifyLoadingStateChange(boolean active) {
        if (articlesView == null) {
            return;
        }

        articlesView.setLoadingIndicator(active);
    }
}
