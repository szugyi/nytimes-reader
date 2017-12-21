package io.szugyi.nytimes.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import io.szugyi.nytimes.articles.ArticleListActivityImpl;
import io.szugyi.nytimes.data.RepositoryModule;

@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = RepositoryModule.class)
    abstract ArticleListActivityImpl articleListActivity();
}
