package io.szugyi.nytimes.data;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.szugyi.nytimes.BuildConfig;
import io.szugyi.nytimes.data.model.Article;
import io.szugyi.nytimes.data.model.MostPopularApiResult;

public class RepositoryImpl implements Repository {
    private static final String ALL_SECTIONS = "all-sections";
    private static final int DEFAULT_PERIOD = 7;

    private final NytimesApi api;

    @Inject
    public RepositoryImpl(NytimesApi api) {
        this.api = api;
    }

    @NonNull
    @Override
    public Observable<List<Article>> getArticles() {
        return api.getArticles(ALL_SECTIONS, DEFAULT_PERIOD, BuildConfig.API_KEY)
                .map(MostPopularApiResult::getResults);
    }
}
