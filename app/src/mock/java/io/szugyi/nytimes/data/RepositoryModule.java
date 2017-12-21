package io.szugyi.nytimes.data;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract Repository provideRepository(RepositoryImpl repository);
}
