package io.szugyi.nytimes.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import io.szugyi.nytimes.articles.ArticleDetailsActivity;
import io.szugyi.nytimes.articles.ArticleDetailsActivityImpl;
import io.szugyi.nytimes.articles.ArticleListActivityImpl;
import io.szugyi.nytimes.articles.ArticlesModule;

@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = ArticlesModule.class)
    abstract ArticleListActivityImpl articleListActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract ArticleDetailsActivityImpl ArticleDetailsActivity();
}
