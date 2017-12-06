package com.muelpatmore.cartooncharacters.data.network.realm.realm_objects;

import com.muelpatmore.cartooncharacters.data.network.models.Character;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Samuel on 06/12/2017.
 */

public class RealmCharacter extends RealmObject {

    @PrimaryKey
    private String name;
    private String text;
    private String firstURL;
    private String iconURL;
    private String iconWidth;
    private String iconHeight;


    public RealmCharacter() {
    }

    public RealmCharacter(Character character) {
        this.text = character.getText();
        this.name = text.substring(0, text.indexOf("-"));
        this.firstURL = character.getFirstURL();
        this.iconURL = character.getIcon().getURL();
        this.iconWidth = character.getIcon().getWidth();
        this.iconHeight = character.getIcon().getHeight();
    }

    public RealmCharacter(String name, String text, String firstURL, String iconURL, String iconWidth, String iconHeight) {
        this.name = name;
        this.text = text;
        this.firstURL = firstURL;
        this.iconURL = iconURL;
        this.iconWidth = iconWidth;
        this.iconHeight = iconHeight;
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

    public String getIconWidth() {
        return iconWidth;
    }

    public void setIconWidth(String iconWidth) {
        this.iconWidth = iconWidth;
    }

    public String getIconHeight() {
        return iconHeight;
    }

    public void setIconHeight(String iconHeight) {
        this.iconHeight = iconHeight;
    }
}
