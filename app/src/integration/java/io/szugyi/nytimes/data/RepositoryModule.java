package io.szugyi.nytimes.data;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module(includes = ApiModule.class)
abstract public class  RepositoryModule {

    @Singleton
    @Binds
    abstract Repository provideRepository(RepositoryImpl repository);
}
