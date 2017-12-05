package com.muelpatmore.cartooncharacters.data;

import com.muelpatmore.cartooncharacters.data.network.APIManager;

/**
 * Created by Samuel on 05/12/2017.
 */

public class DataManager {

    private APIManager apiManager;

    public DataManager() {
        this.apiManager = new APIManager();
    }

    public void getCharacterList() {
        apiManager.getCharacterList();
    }
}
