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

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);

        Realm.init(this.getApplicationContext());
        RealmConfiguration realmConfig = new RealmConfiguration.Builder()
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfig);
    }
}
