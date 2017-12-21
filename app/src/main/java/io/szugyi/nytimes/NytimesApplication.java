package io.szugyi.nytimes;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import io.szugyi.nytimes.di.DaggerAppComponent;
import timber.log.Timber;

public class NytimesApplication extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
