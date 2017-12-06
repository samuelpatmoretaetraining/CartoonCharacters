package com.muelpatmore.cartooncharacters.data.event_bus;

/**
 * Created by Samuel on 05/12/2017.
 */

public class CharacterDetailsReady {
    public CharacterModel character;

    public CharacterDetailsReady(CharacterModel character) {
        this.character = character;
    }
}
