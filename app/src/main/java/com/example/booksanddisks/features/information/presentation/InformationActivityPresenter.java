package com.example.booksanddisks.features.information.presentation;

import java.util.ArrayList;

public class InformationActivityPresenter {

    protected InformationView view;
    private ArrayList<String> information;

    public InformationActivityPresenter(ArrayList<String> information) {
        this.information = information;
    }

    public void attachView(InformationView view){
        this.view = view;
        onViewReady();
    }

    public void detachView(){
        this.view = null;
    }

    protected void onViewReady(){
        view.showProgress();
        view.showInformation(information.get(0), information.get(1), information.get(2), information.get(3), information.get(4));
        view.hideProgress();
    }
}
