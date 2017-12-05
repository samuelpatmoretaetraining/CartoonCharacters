package com.muelpatmore.cartooncharacters.data.network;

import android.util.Log;

import com.muelpatmore.cartooncharacters.BuildConfig;
import com.muelpatmore.cartooncharacters.data.event_bus.CharacterListReady;
import com.muelpatmore.cartooncharacters.data.network.models.CharacterListModel;
import com.muelpatmore.cartooncharacters.data.network.models.CharacterModel;
import com.muelpatmore.cartooncharacters.data.network.network_utils.RequestInterface;
import com.muelpatmore.cartooncharacters.data.network.network_utils.SchedulerProvider;
import com.muelpatmore.cartooncharacters.data.network.network_utils.SchedulerProviderInterface;
import com.muelpatmore.cartooncharacters.data.network.network_utils.ServerConnectionManager;

import org.greenrobot.eventbus.EventBus;


import java.util.ArrayList;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Samuel on 05/12/2017.
 */

public class APIManager {

    private static final String TAG = "APIManager";

    private RequestInterface request;
    private CompositeDisposable compositeDisposable;
    private SchedulerProviderInterface schedulerProvider;

    public APIManager() {
        this.request = ServerConnectionManager.getServerConnection();
        this.compositeDisposable = new CompositeDisposable();
        this.schedulerProvider = new SchedulerProvider();
    }

    public void getCharacterList() {
        compositeDisposable.add(
                request.getCharacterList()
                        .observeOn(schedulerProvider.ui())
                        .subscribeOn(schedulerProvider.io())
                        .subscribe(characterList -> {
                            cropNames(characterList);
                        }, throwable -> throwable.printStackTrace())
        );
    }



    public void cropNames(CharacterListModel characterListModel) {
        io.reactivex.Observable.just(characterListModel)
                .map(x -> x.getCharacterModels())
                .flatMapIterable(x -> x)
                .map(x -> x.getText())
                .toList()
                .subscribe(names -> {
                        EventBus.getDefault().post(
                                new CharacterListReady(
                                        new ArrayList<>(names)));}
                , throwable -> throwable.printStackTrace());
    }

//    public void getCharacterList() {
//        compositeDisposable.add(
//                request.getCharacterList()
//                        .map(x -> x.getCharacterModels())
//                        .flatMapIterable(x -> x)
//                        .map(x -> x.getText())
//                        .toList()
//                        .observeOn(schedulerProvider.ui())
//                        .subscribeOn(schedulerProvider.io())
//                        .subscribe(characterList -> {
//                            ArrayList<String> characterArrayList = new ArrayList<>(characterList);
//                            for (String s : characterArrayList) {
//                                Log.i(TAG, s);
//                            }
//                            EventBus.getDefault().post(new CharacterListReady(characterArrayList));
//                        }, throwable -> throwable.printStackTrace())
//        );
//    }
}
