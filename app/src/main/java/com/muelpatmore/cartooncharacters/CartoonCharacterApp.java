package com.muelpatmore.cartooncharacters;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Samuel on 06/12/2017.
 */

public class CartoonCharacterApp extends Application {

    private static Context mContext;
    private static CartoonCharacterApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
        instance = this;
        mContext = this.getApplicationContext();

        Realm.init(mContext);
        RealmConfiguration realmConfig = new RealmConfiguration.Builder()
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfig);
    }

    public static Context getContext() {
        return mContext;
    }

    public static CartoonCharacterApp getInstance() {
        return instance;
    }
}
