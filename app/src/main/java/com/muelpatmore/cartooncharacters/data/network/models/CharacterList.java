package com.muelpatmore.cartooncharacters.data.network.models;

/**
 * Created by Samuel on 06/12/2017.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CharacterList {

    @SerializedName("Type")
    @Expose
    private String type;
    @SerializedName("ImageIsLogo")
    @Expose
    private Integer imageIsLogo;
    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("DefinitionURL")
    @Expose
    private String definitionURL;
    @SerializedName("AbstractSource")
    @Expose
    private String abstractSource;
    @SerializedName("ImageWidth")
    @Expose
    private Integer imageWidth;
    @SerializedName("ImageHeight")
    @Expose
    private Integer imageHeight;
    @SerializedName("AnswerType")
    @Expose
    private String answerType;
    @SerializedName("RelatedTopics")
    @Expose
    private List<Character> character = null;
    @SerializedName("Definition")
    @Expose
    private String definition;
    @SerializedName("DefinitionSource")
    @Expose
    private String definitionSource;
    @SerializedName("Infobox")
    @Expose
    private String infobox;
    @SerializedName("Answer")
    @Expose
    private String answer;
    @SerializedName("Image")
    @Expose
    private String image;
    @SerializedName("Abstract")
    @Expose
    private String _abstract;
    @SerializedName("Results")
    @Expose
    private List<Object> results = null;
    @SerializedName("AbstractURL")
    @Expose
    private String abstractURL;
    @SerializedName("AbstractText")
    @Expose
    private String abstractText;
    @SerializedName("Redirect")
    @Expose
    private String redirect;
    @SerializedName("Entity")
    @Expose
    private String entity;
    @SerializedName("Heading")
    @Expose
    private String heading;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getImageIsLogo() {
        return imageIsLogo;
    }

    public void setImageIsLogo(Integer imageIsLogo) {
        this.imageIsLogo = imageIsLogo;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public String getDefinitionURL() {
        return definitionURL;
    }

    public void setDefinitionURL(String definitionURL) {
        this.definitionURL = definitionURL;
    }

    public String getAbstractSource() {
        return abstractSource;
    }

    public void setAbstractSource(String abstractSource) {
        this.abstractSource = abstractSource;
    }

    public Integer getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(Integer imageWidth) {
        this.imageWidth = imageWidth;
    }

    public Integer getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(Integer imageHeight) {
        this.imageHeight = imageHeight;
    }

    public String getAnswerType() {
        return answerType;
    }

    public void setAnswerType(String answerType) {
        this.answerType = answerType;
    }

    public List<Character> getCharacter() {
        return character;
    }

    public void setCharacter(List<Character> character) {
        this.character = character;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getDefinitionSource() {
        return definitionSource;
    }

    public void setDefinitionSource(String definitionSource) {
        this.definitionSource = definitionSource;
    }

    public String getInfobox() {
        return infobox;
    }

    public void setInfobox(String infobox) {
        this.infobox = infobox;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAbstract() {
        return _abstract;
    }

    public void setAbstract(String _abstract) {
        this._abstract = _abstract;
    }

    public List<Object> getResults() {
        return results;
    }

    public void setResults(List<Object> results) {
        this.results = results;
    }

    public String getAbstractURL() {
        return abstractURL;
    }

    public void setAbstractURL(String abstractURL) {
        this.abstractURL = abstractURL;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }
}