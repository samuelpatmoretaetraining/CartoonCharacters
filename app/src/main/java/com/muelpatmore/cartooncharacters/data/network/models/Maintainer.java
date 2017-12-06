package com.muelpatmore.cartooncharacters.data.network.models;

/**
 * Created by Samuel on 06/12/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Maintainer {

    @SerializedName("github")
    @Expose
    private String github;

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }
}