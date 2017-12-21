package io.szugyi.nytimes;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import io.reactivex.Observable;

public class DataPresenterImpl implements DataPresenter {

    @Inject
    public DataPresenterImpl() {
        // Dagger needs an injectable constructor
    }

    @NonNull
    @Override
    public Observable<String> search(String query) {
        return Observable.just("Mock search: " + query);
    }
}
