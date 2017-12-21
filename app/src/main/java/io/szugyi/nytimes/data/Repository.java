package io.szugyi.nytimes.data;

import android.support.annotation.NonNull;

import io.reactivex.Observable;

public interface Repository {

    @NonNull
    Observable<String> search(String query);
}
