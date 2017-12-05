package com.muelpatmore.cartooncharacters.data.event_bus;

import com.muelpatmore.cartooncharacters.data.network.models.CharacterModel;

/**
 * Created by Samuel on 05/12/2017.
 */

public class CharacterDetailsReady {
    public CharacterModel character;

    public CharacterDetailsReady(CharacterModel character) {
        this.character = character;
    }
}
