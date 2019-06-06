package com.example.booksanddisks.features.products.presentation;

import com.example.booksanddisks.app.App;
import com.example.booksanddisks.app.db.ProductsDatabase;
import com.example.booksanddisks.features.products.data.ProductsDataSource;
import com.example.booksanddisks.features.products.data.ProductsDataSourceImpl;
import com.example.booksanddisks.features.products.data.ProductsRepositoryImpl;
import com.example.booksanddisks.features.products.domain.ProductsInteractor;
import com.example.booksanddisks.features.products.domain.ProductsInteractorImpl;
import com.example.booksanddisks.features.products.domain.ProductsRepository;

public class PresenterFactory {

    public static ProductsActivityPresenter getPresenter(){

        final ProductsDatabase database = App.getDataBase();
        final ProductsDataSource productsDataSource = new ProductsDataSourceImpl(database);
        final ProductsRepository productsRepository = new ProductsRepositoryImpl(productsDataSource);
        final ProductsInteractor productsInteractor = new ProductsInteractorImpl(productsRepository);

        return new ProductsActivityPresenter(productsInteractor);
    }
}
