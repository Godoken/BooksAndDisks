package com.example.booksanddisks.features.products.presentation;

import com.example.booksanddisks.features.products.domain.Product;

import java.util.ArrayList;
import java.util.List;

public interface ProductsListView {

    void showProgress();

    void hideProgress();

    void showError(String message);

    void loadProducts();

    void setProductsToAdapter(List<Product> productList);

    void loadInformation(ArrayList<String> arrayList);

    void openQuitDialog();
}
