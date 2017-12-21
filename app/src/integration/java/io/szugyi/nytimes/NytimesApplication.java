package io.szugyi.nytimes;

import com.facebook.stetho.Stetho;

public class NytimesApplication extends BaseNytimesApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
