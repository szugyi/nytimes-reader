package io.szugyi.nytimes.data;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.szugyi.nytimes.data.model.Article;

public class RepositoryImpl implements Repository {

    @Inject
    public RepositoryImpl() {
    }

    @NonNull
    @Override
    public Observable<List<Article>> getArticles() {
        return Observable.empty();
    }
}
