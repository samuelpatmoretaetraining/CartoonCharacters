package com.muelpatmore.cartooncharacters.data.network.network_utils;

import com.muelpatmore.cartooncharacters.BuildConfig;
import com.muelpatmore.cartooncharacters.data.network.models.CharacterListModel;
import com.muelpatmore.cartooncharacters.data.network.models.CharacterModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Samuel on 05/12/2017.
 */

public interface RequestInterface {

    @GET(BuildConfig.api_query)
    Observable<CharacterListModel> getCharacterList();
}
