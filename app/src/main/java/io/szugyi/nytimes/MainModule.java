package io.szugyi.nytimes;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @Provides
    DataPresenter provideDataPresenter(DataPresenterImpl dataPresenter) {
        return dataPresenter;
    }
}
