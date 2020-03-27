package com.marfiks.breizhmeteo.ui.propos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProposViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ProposViewModel() {

        mText = new MutableLiveData<>();
        mText.setValue("Dans le cadre de notre deuxième année d'école d'ingénieurs, nous devons développer une application Android utilisant une API.\n\n" +
                "Nous avons décidés de créer une application permettant d'obtenir, à partir de l'API OpenWeather, la météo des principales villes bretonnes.\n\n" +
                "Dans cette application vous trouverez donc un onglet permettant visualiser les différentes villes, un onglet avec des photos de ces différentes villes ainsi que cette page, résumant l'essence de l'application.\n\n\n" +
                "Projet Réalisé par Quentin GIRAUD et Jules FRANZI - IBO7 ESILV");

    }

    public LiveData<String> getText() {
        return mText;
    }
}