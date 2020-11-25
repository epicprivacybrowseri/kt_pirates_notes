package ua.com.anyapps.kt_pirates_notes.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ua.com.anyapps.daggerprovidesharedpreferences.TestClass;

@Module
public class TestModule {
    @Provides
    @Singleton
    public TestClass provideTestClass(){
        return new TestClass("VVV");
    }
}
