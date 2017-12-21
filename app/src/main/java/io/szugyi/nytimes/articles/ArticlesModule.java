package io.szugyi.nytimes.articles;

import dagger.Binds;
import dagger.Module;
import io.szugyi.nytimes.di.ActivityScoped;

@Module
public abstract class ArticlesModule {

    @ActivityScoped
    @Binds
    abstract ArticlesContract.Presenter articlesPresenter(ArticlesPresenter presenter);
}
