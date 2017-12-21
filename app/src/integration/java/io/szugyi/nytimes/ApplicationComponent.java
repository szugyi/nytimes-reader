package io.szugyi.nytimes;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, MainModule.class, ApiModule.class})
public interface ApplicationComponent {

    void inject(MainActivity activity);
}
