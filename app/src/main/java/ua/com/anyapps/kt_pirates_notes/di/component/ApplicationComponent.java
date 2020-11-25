package ua.com.anyapps.kt_pirates_notes.di.component;

import javax.inject.Singleton;

import dagger.Component;
import ua.com.anyapps.daggerprovidesharedpreferences.MainActivity;
import ua.com.anyapps.daggerprovidesharedpreferences.di.module.ApplicationModule;
import ua.com.anyapps.daggerprovidesharedpreferences.di.module.TestModule;

@Singleton
@Component(modules = {ApplicationModule.class, TestModule.class})
public interface ApplicationComponent {
    void inject(MainActivity mainActivity);
}
