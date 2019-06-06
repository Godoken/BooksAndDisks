package com.example.booksanddisks.features.products.presentation;

import com.example.booksanddisks.R;
import com.example.booksanddisks.app.App;
import com.example.booksanddisks.features.products.domain.Product;
import com.example.booksanddisks.features.products.domain.ProductsInteractor;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class ProductsActivityPresenter {

    protected ProductsListView view;
    private ProductsInteractor productsInteractor;

    public ProductsActivityPresenter(ProductsInteractor productsInteractor) {
        this.productsInteractor = productsInteractor;
    }

    public void attachView(ProductsListView view){
        this.view = view;
        onViewReady();
    }

    public void detachView(){
        this.view = null;
    }

    protected void onViewReady(){
        view.loadProducts();
    }

    public void loadProducts() {
        Observable<List<Product>> listObservable = productsInteractor.loadProducts().toObservable();
        Observer<List<Product>> listObserver = new Observer<List<Product>>() {
            @Override
            public void onSubscribe(Disposable d) {
                view.showProgress();
            }

            @Override
            public void onNext(List<Product> products) {
                if (products.size() != 0){
                    view.setProductsToAdapter(products);
                } else {
                    view.showError(App.getContext().getString(R.string.error_event_list_clear));
                }
            }

            @Override
            public void onError(Throwable e) {
                view.hideProgress();
                view.showError(App.getContext().getString(R.string.error_events_list_server));
            }

            @Override
            public void onComplete() {
                view.hideProgress();
            }
        };
        listObservable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listObserver);
    }

    public void onProductSelected(Product product) {
        view.showProgress();
        view.loadInformation(product);
        view.hideProgress();
    }

    public void onBackPressed() {
        view.showProgress();
        view.openQuitDialog();
        view.hideProgress();
    }
}
