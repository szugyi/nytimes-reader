package io.szugyi.nytimes;

import android.app.Application;

public abstract class BaseNytimesApplication extends Application {

    private static BaseNytimesApplication instance;

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public static BaseNytimesApplication getInstance() {
        return instance;
    }
}
