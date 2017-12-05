
package com.muelpatmore.cartooncharacters.data.network.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CharacterListModel {

    @SerializedName("RelatedTopics")
    @Expose
    private List<CharacterModel> characterModels = null;

    public List<CharacterModel> getCharacterModels() {
        return characterModels;
    }

    public void setCharacterModels(List<CharacterModel> characterModels) {
        this.characterModels = characterModels;
    }

}
