package io.szugyi.nytimes.articles;

import android.support.annotation.NonNull;

import java.util.List;

import io.szugyi.nytimes.BasePresenter;
import io.szugyi.nytimes.BaseView;
import io.szugyi.nytimes.data.model.Article;

public interface ArticlesContract {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        void showArticles(List<Article> articles);

        void showArticleDetails(String url);
    }

    interface Presenter extends BasePresenter<View> {

        void loadArticles();

        void openArticleDetails(@NonNull Article article);
    }
}
