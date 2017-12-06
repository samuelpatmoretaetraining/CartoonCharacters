package com.muelpatmore.cartooncharacters.data;

import com.muelpatmore.cartooncharacters.data.network.APIManager;

/**
 * Created by Samuel on 05/12/2017.
 */

public class DataManager
        implements DataManagerInterface{

    private APIManager apiManager;

    public DataManager() {
        this.apiManager = new APIManager();
    }

    /** {@inheritDoc} */
    @Override
    public void getCharacterList() {
        apiManager.getCharacterList();
    }

    /** {@inheritDoc} */
    @Override
    public void getCharacterDetails(String name) {
        apiManager.getCharacterDetails(name);
    }
}
