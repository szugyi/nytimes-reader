package io.szugyi.nytimes;

import android.support.annotation.NonNull;

import java.io.IOException;

import javax.inject.Inject;

import io.reactivex.Observable;

public class DataPresenterImpl implements DataPresenter {

    private final NytimesApi api;

    @Inject
    public DataPresenterImpl(NytimesApi api) {
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
