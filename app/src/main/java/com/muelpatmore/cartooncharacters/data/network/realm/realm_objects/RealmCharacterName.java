package com.muelpatmore.cartooncharacters.data.network.realm.realm_objects;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Samuel on 06/12/2017.
 */

public class RealmCharacterName extends RealmObject {
    @PrimaryKey
    private String name;

    public RealmCharacterName() {}

    public RealmCharacterName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
