package com.muelpatmore.cartooncharacters.data.network.network_utils;

import com.muelpatmore.cartooncharacters.BuildConfig;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Samuel on 05/12/2017.
 */

public interface RequestInterface {

    @GET(BuildConfig.api_query)
    Observable<CharacterListModel> getCharacterList();
}
