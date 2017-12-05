package com.muelpatmore.cartooncharacters.data.network;

import android.util.Log;

import com.muelpatmore.cartooncharacters.BuildConfig;
import com.muelpatmore.cartooncharacters.data.event_bus.CharacterListReady;
import com.muelpatmore.cartooncharacters.data.network.models.CharacterModel;
import com.muelpatmore.cartooncharacters.data.network.network_utils.RequestInterface;
import com.muelpatmore.cartooncharacters.data.network.network_utils.SchedulerProvider;
import com.muelpatmore.cartooncharacters.data.network.network_utils.SchedulerProviderInterface;
import com.muelpatmore.cartooncharacters.data.network.network_utils.ServerConnectionManager;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

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
                    .map(x -> x.getCharacterModels())
                    .flatMapIterable(x -> x)
                    .map(x -> x.getText())
                    .toList()
                    .observeOn(schedulerProvider.ui())
                    .subscribeOn(schedulerProvider.io())
                    .subscribe(characterList -> {
                        ArrayList<String> characterArrayList = new ArrayList<>(characterList);
                        for (String s : characterArrayList) {
                            Log.i(TAG, s);
                        }
                        EventBus.getDefault().post(new CharacterListReady(characterArrayList));
                    }, throwable -> throwable.printStackTrace())
        );
    }
}
