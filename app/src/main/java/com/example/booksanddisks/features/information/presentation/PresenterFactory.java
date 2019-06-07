package com.example.booksanddisks.features.information.presentation;

import java.util.ArrayList;

public class PresenterFactory {
    public static InformationActivityPresenter getPresenter(ArrayList<String> information){
        return new InformationActivityPresenter(information);
    }
}
