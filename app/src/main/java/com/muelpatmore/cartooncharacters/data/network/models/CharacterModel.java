
package com.muelpatmore.cartooncharacters.data.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CharacterModel {

    @SerializedName("Text")
    @Expose
    private String text;
    @SerializedName("CharacterIcon")
    @Expose
    private CharacterIcon characterIcon;
    @SerializedName("Result")
    @Expose
    private String result;
    @SerializedName("FirstURL")
    @Expose
    private String firstURL;




    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public CharacterIcon getCharacterIcon() {
        return characterIcon;
    }

    public void setCharacterIcon(CharacterIcon characterIcon) {
        this.characterIcon = characterIcon;
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

}
