package io.szugyi.nytimes.data;

import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Observable;
import io.szugyi.nytimes.data.model.Article;

public interface Repository {

    @NonNull
    Observable<List<Article>> getArticles();
}
