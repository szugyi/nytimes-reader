package io.szugyi.nytimes.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import io.szugyi.nytimes.NytimesApplication;
import io.szugyi.nytimes.data.Repository;
import io.szugyi.nytimes.data.RepositoryModule;

@Singleton
@Component(modules = {RepositoryModule.class,
        ApplicationModule.class,
        ActivityBindingModule.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<NytimesApplication> {

    Repository getRepository();

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
