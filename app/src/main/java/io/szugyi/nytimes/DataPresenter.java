package io.szugyi.nytimes;

import android.support.annotation.NonNull;

import io.reactivex.Observable;

public interface DataPresenter {

    @NonNull
    Observable<String> search(String query);
}
