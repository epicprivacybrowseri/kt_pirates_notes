package ua.com.anyapps.kt_pirates_notes.di;

import android.app.Application;

import ua.com.anyapps.daggerprovidesharedpreferences.di.component.ApplicationComponent;
import ua.com.anyapps.daggerprovidesharedpreferences.di.component.DaggerApplicationComponent;
import ua.com.anyapps.daggerprovidesharedpreferences.di.module.ApplicationModule;
//import ua.com.anyapps.daggerprovidesharedpreferences.di.components.DaggerTestComponent;


public class App extends Application {
    private static ApplicationComponent applicationComponent;
    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }

    public ApplicationComponent getApplciationComponent(){
        return applicationComponent;
    }
}
