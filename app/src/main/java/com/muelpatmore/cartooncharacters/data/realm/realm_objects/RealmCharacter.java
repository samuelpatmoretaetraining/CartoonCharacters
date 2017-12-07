package com.muelpatmore.cartooncharacters.data.realm.realm_objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.muelpatmore.cartooncharacters.data.network.models.Character;
import com.muelpatmore.cartooncharacters.data.network.models.Icon;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Samuel on 06/12/2017.
 */

public class RealmCharacter extends RealmObject {

    @PrimaryKey
    private String name;
    private Icon icon;
    private String firstURL;
    private String text;
    private String result;


    public RealmCharacter() {
    }

    public RealmCharacter(String name, Icon icon, String firstURL, String text, String result) {
        this.name = name;
        this.icon = icon;
        this.firstURL = firstURL;
        this.text = text;
        this.result = result;
    }

    public RealmCharacter(Icon icon, String firstURL, String text, String result) {
        if (text.contains("-")) {
            this.name = text.substring(0, text.indexOf("-"));
        }
        this.icon = icon;
        this.firstURL = firstURL;
        this.text = text;
        this.result = result;
    }

    public RealmCharacter(Character character) {
        if (character.getText().contains("-")) {
            this.name = character.getText().substring(0, text.indexOf("-"));
        }
        this.icon = character.getIcon();
        this.firstURL = character.getFirstURL();
        this.text = character.getText();
        this.result = character.getResult();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getFirstURL() {
        return firstURL;
    }

    public void setFirstURL(String firstURL) {
        this.firstURL = firstURL;
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
}
