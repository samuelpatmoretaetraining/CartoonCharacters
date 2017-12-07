package com.muelpatmore.cartooncharacters.data.realm.realm_objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.muelpatmore.cartooncharacters.data.CharacterInterface;
import com.muelpatmore.cartooncharacters.data.network.models.Character;
import com.muelpatmore.cartooncharacters.data.network.models.Icon;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * RealmObject subclass to store information in a Realm database while providing a
 * CharacterInterface interface for its use.
 */
public class RealmCharacter
        extends RealmObject
            implements CharacterInterface {

    @PrimaryKey
    private String name;
    private String text;
    private String result;
    private String firstURL;
    private String iconURL;

    public RealmCharacter() {
    }

    public RealmCharacter(String name, String text, String result, String firstURL, String iconURL) {
        this.name = name;
        this.text = text;
        this.result = result;
        this.firstURL = firstURL;
        this.iconURL = iconURL;
    }

    public RealmCharacter(String text, String result, String firstURL, String iconURL) {
        if (text.contains("-")) {
            this.name = text.substring(0, text.indexOf("-") - 2);
        }
        this.text = text;
        this.result = result;
        this.firstURL = firstURL;
        this.iconURL = iconURL;
    }

    public RealmCharacter(CharacterInterface character) {
        if (character.getText().contains("-")) {
            this.name = character.getText().substring(0, character.getText().indexOf("-") - 2);
        }
        this.text = character.getText();
        this.result = character.getResult();
        this.firstURL = character.getFirstURL();
        this.iconURL = character.getIconURL();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getFirstURL() {
        return firstURL;
    }

    public void setFirstURL(String firstURL) {
        this.firstURL = firstURL;
    }

    public String getIconURL() {
        return iconURL;
    }

    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }
}
