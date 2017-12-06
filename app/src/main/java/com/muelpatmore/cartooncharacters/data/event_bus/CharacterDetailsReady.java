package com.muelpatmore.cartooncharacters.data.event_bus;

import com.muelpatmore.cartooncharacters.data.network.models.Character;

/**
 * Created by Samuel on 05/12/2017.
 */

public class CharacterDetailsReady {
    public Character character;

    public CharacterDetailsReady(Character character) {
        this.character = character;
    }
}
