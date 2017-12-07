package com.muelpatmore.cartooncharacters.data.network.models;

/**
 * Created by Samuel on 06/12/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.muelpatmore.cartooncharacters.data.CharacterInterface;

public class Character implements CharacterInterface {

    @SerializedName("Icon")
    @Expose
    private Icon icon;
    @SerializedName("FirstURL")
    @Expose
    private String firstURL;
    @SerializedName("Text")
    @Expose
    private String text;
    @SerializedName("Result")
    @Expose
    private String result;

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

    @Override
    public String getIconURL() {
        return getIcon().getURL();
    }

    @Override
    public String getName() {
        if (text.contains("-")) {
            return text.substring(0, text.indexOf("-") - 2);
        }
        return null;
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