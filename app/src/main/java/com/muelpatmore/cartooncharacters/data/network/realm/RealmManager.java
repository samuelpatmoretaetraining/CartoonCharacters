package com.muelpatmore.cartooncharacters.data.network.realm;

import com.muelpatmore.cartooncharacters.data.network.realm.realm_objects.RealmCharacterName;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Samuel on 06/12/2017.
 */

public class RealmManager {

    private Realm realm;

    public RealmManager(Realm realm) {
        this.realm = realm;
    }

    public void putCharacterName(String name) {
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(new RealmCharacterName(name));
        realm.commitTransaction();
    }

    public String getCharacterName(String name) {
        RealmCharacterName result =
                realm.where(RealmCharacterName.class)
                .equalTo("name", name)
                .findFirst();
        if (result != null) {
            return result.getName();
        } else {
            return null;
        }
    }

    public void putCharacterNameList(List<String> names) {
        realm.beginTransaction();
        List<RealmCharacterName> realmNames= new ArrayList<>();
        for(String s : names) {
            realmNames.add(new RealmCharacterName(s));
        }
        realm.copyToRealmOrUpdate(realmNames);
        realm.commitTransaction();
    }

    public List<String> getCharacterList() {
        RealmResults<RealmCharacterName> realmResults =
                realm.where(RealmCharacterName.class).findAll();
        ArrayList<String> names = new ArrayList<>();
        for(RealmCharacterName name : realmResults) {
            names.add(name.getName());
        }
        return names;
    }
}
