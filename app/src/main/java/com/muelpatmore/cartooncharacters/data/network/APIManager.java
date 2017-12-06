package com.muelpatmore.cartooncharacters.data.network;

import android.util.Log;

import com.muelpatmore.cartooncharacters.data.event_bus.CharacterDetailsReady;
import com.muelpatmore.cartooncharacters.data.event_bus.CharacterListReady;
import com.muelpatmore.cartooncharacters.data.network.models.Character;
import com.muelpatmore.cartooncharacters.data.network.models.CharacterList;
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

public class APIManager
        implements APIManagerInterface {

    private static final String TAG = "APIManager";

    private RequestInterface request;
    private CompositeDisposable compositeDisposable;
    private SchedulerProviderInterface schedulerProvider;

    /**
     * Constructor for API manager.
     */
    public APIManager() {
        this.request = ServerConnectionManager.getServerConnection();
        this.compositeDisposable = new CompositeDisposable();
        this.schedulerProvider = new SchedulerProvider();
    }

    /**
     * Queries the API and Posts an ArrayList of name strings in an EventBus CharacterListReady
     * object.
     */
    @Override
    public void getCharacterList() {
        compositeDisposable.add(
                request.getCharacterList()
                        .observeOn(schedulerProvider.ui())
                        .subscribeOn(schedulerProvider.io())
                        .subscribe(this::cropNames, Throwable::printStackTrace)
        );
    }

    /**
     * Utility function to trim raw API data of all characters to an array list of their names,
     * which is Posted by as an EventBus CharacterListReady object.
     * @param characterListModel
     */
    private void cropNames(CharacterList characterListModel) {
        io.reactivex.Observable.just(characterListModel)
                .map(CharacterList::getCharacter)
                .flatMapIterable(x -> x)
                .map(Character::getText)
                .toList()
                .observeOn(schedulerProvider.ui())
                .subscribeOn(schedulerProvider.computation())
                .subscribe(names -> {
                    Log.i(TAG, names.toString());
                        EventBus.getDefault().post(
                                new CharacterListReady(
                                        new ArrayList<>(names)));}
                , Throwable::printStackTrace);
    }

    /**
     * Queries the API and Posts a CharacterListModel of the character with the same name in an
     * EventBus CharacterDetailReady object.
     * object.
     */
    @Override
    public void getCharacterDetails(String name) {
        compositeDisposable.add(
                request.getCharacterList()
                        .observeOn(schedulerProvider.ui())
                        .subscribeOn(schedulerProvider.io())
                        .subscribe(characterList -> cropCharacter(characterList, name),
                                Throwable::printStackTrace)
        );
    }

    /**
     * Utility function to trim raw API data of all characters to a single CharacterListModel of
     * the character with the same name, which is then Posted in an EventBus CharacterDetailReady
     * object.
     */
    private void cropCharacter(CharacterList characterList, String name) {
        io.reactivex.Observable.just(characterList)
                .map(CharacterList::getCharacter)
                .flatMapIterable(x -> x)
                .filter( x -> x.getText().startsWith(name))
                .observeOn(schedulerProvider.ui())
                .subscribeOn(schedulerProvider.computation())
                .subscribe(character -> {
                            EventBus.getDefault().post(
                                    new CharacterDetailsReady(character));}
                        , Throwable::printStackTrace);
    }
}