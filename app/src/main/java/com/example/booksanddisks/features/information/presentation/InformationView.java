package com.example.booksanddisks.features.information.presentation;

public interface InformationView {

    void showProgress();

    void hideProgress();

    void showError(String message);

    void showInformation(String s, String s1, String s2, String s3, String s4);
}
