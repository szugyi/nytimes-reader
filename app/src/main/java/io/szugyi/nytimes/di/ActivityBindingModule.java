package io.szugyi.nytimes.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import io.szugyi.nytimes.MainActivityImpl;
import io.szugyi.nytimes.data.RepositoryModule;

@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = RepositoryModule.class)
    abstract MainActivityImpl mainActivity();
}
