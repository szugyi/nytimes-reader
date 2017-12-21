package io.szugyi.nytimes.data;

import android.support.annotation.NonNull;

import java.io.IOException;

import javax.inject.Inject;

import io.reactivex.Observable;

public class RepositoryImpl implements Repository {

    private final NytimesApi api;

    @Inject
    public RepositoryImpl(NytimesApi api) {
        this.api = api;
    }

    @NonNull
    @Override
    public Observable<String> search(String query) {
        return api.search(query)
                .flatMap(result -> {
                    try {
                        String str = result.string();
                        return Observable.just(str);
                    } catch (IOException e) {
                        return Observable.error(e);
                    }
                });

    }
}
