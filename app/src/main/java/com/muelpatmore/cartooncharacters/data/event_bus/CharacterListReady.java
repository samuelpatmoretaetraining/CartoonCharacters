package com.muelpatmore.cartooncharacters.data.event_bus;

import com.muelpatmore.cartooncharacters.data.network.models.CharacterModel;

import java.util.ArrayList;

/**
 * Created by Samuel on 05/12/2017.
 */

public class CharacterListReady {
    public ArrayList<String> characterList;

    public CharacterListReady(ArrayList<String> characterList) {
        this.characterList = characterList;
    }
}
