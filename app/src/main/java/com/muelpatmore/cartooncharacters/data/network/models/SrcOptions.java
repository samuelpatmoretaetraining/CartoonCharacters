package com.muelpatmore.cartooncharacters.data.network.models;

/**
 * Created by Samuel on 06/12/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SrcOptions {

    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("skip_abstract")
    @Expose
    private Integer skipAbstract;
    @SerializedName("skip_qr")
    @Expose
    private String skipQr;
    @SerializedName("src_info")
    @Expose
    private String srcInfo;
    @SerializedName("skip_abstract_paren")
    @Expose
    private Integer skipAbstractParen;
    @SerializedName("is_mediawiki")
    @Expose
    private Integer isMediawiki;
    @SerializedName("min_abstract_length")
    @Expose
    private String minAbstractLength;
    @SerializedName("is_wikipedia")
    @Expose
    private Integer isWikipedia;
    @SerializedName("skip_end")
    @Expose
    private String skipEnd;
    @SerializedName("skip_image_name")
    @Expose
    private Integer skipImageName;
    @SerializedName("directory")
    @Expose
    private String directory;
    @SerializedName("is_fanon")
    @Expose
    private Integer isFanon;
    @SerializedName("source_skip")
    @Expose
    private String sourceSkip;
    @SerializedName("skip_icon")
    @Expose
    private Integer skipIcon;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getSkipAbstract() {
        return skipAbstract;
    }

    public void setSkipAbstract(Integer skipAbstract) {
        this.skipAbstract = skipAbstract;
    }

    public String getSkipQr() {
        return skipQr;
    }

    public void setSkipQr(String skipQr) {
        this.skipQr = skipQr;
    }

    public String getSrcInfo() {
        return srcInfo;
    }

    public void setSrcInfo(String srcInfo) {
        this.srcInfo = srcInfo;
    }

    public Integer getSkipAbstractParen() {
        return skipAbstractParen;
    }

    public void setSkipAbstractParen(Integer skipAbstractParen) {
        this.skipAbstractParen = skipAbstractParen;
    }

    public Integer getIsMediawiki() {
        return isMediawiki;
    }

    public void setIsMediawiki(Integer isMediawiki) {
        this.isMediawiki = isMediawiki;
    }

    public String getMinAbstractLength() {
        return minAbstractLength;
    }

    public void setMinAbstractLength(String minAbstractLength) {
        this.minAbstractLength = minAbstractLength;
    }

    public Integer getIsWikipedia() {
        return isWikipedia;
    }

    public void setIsWikipedia(Integer isWikipedia) {
        this.isWikipedia = isWikipedia;
    }

    public String getSkipEnd() {
        return skipEnd;
    }

    public void setSkipEnd(String skipEnd) {
        this.skipEnd = skipEnd;
    }

    public Integer getSkipImageName() {
        return skipImageName;
    }

    public void setSkipImageName(Integer skipImageName) {
        this.skipImageName = skipImageName;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public Integer getIsFanon() {
        return isFanon;
    }

    public void setIsFanon(Integer isFanon) {
        this.isFanon = isFanon;
    }

    public String getSourceSkip() {
        return sourceSkip;
    }

    public void setSourceSkip(String sourceSkip) {
        this.sourceSkip = sourceSkip;
    }

    public Integer getSkipIcon() {
        return skipIcon;
    }

    public void setSkipIcon(Integer skipIcon) {
        this.skipIcon = skipIcon;
    }
}