package com.muelpatmore.cartooncharacters.data.event_bus;

/**
 * Created by Samuel on 05/12/2017.
 */

public class CharacterSelected {
    public final String name;

    public CharacterSelected(String name) {
        this.name = name;
    }
}
