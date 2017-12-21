package io.szugyi.nytimes.data;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import io.reactivex.Observable;

public class RepositoryImpl implements Repository {

    @Inject
    public RepositoryImpl() {
    }

    @NonNull
    @Override
    public Observable<String> search(String query) {
        return Observable.just("Mock search: " + query);
    }
}
