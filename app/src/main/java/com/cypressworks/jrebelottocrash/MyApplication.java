package com.cypressworks.jrebelottocrash;

import android.app.Application;

import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

public class MyApplication extends Application {

    @Module
    public static class ApplicationModule {

        @Provides
        @Singleton
        Bus provideTracker() {
            return new Bus();
        }

    }

    @Singleton
    @Component(
            modules = {ApplicationModule.class})
    public interface ApplicationComponent {
        void inject(MainActivity myApplication);
    }

    public static ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerMyApplication_ApplicationComponent.builder().build();

    }
}
