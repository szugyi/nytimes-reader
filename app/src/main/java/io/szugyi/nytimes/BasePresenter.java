package io.szugyi.nytimes;

public interface BasePresenter<T> {

    void takeView(T view);

    void dropView();

}
