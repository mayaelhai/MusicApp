package com.example.musicapp.UtilsPackage;
import android.app.Application;

public class ApplicationUtil extends Application {

    private static Application application;

    @Override
    public void onCreate() {
        super.onCreate();

        application = this;
    }

    public static Application getApplication() {
        return application;
    }

}
