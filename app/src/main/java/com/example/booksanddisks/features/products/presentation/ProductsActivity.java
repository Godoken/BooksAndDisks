package com.example.booksanddisks.features.products.presentation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.booksanddisks.R;
import com.example.booksanddisks.features.products.domain.Product;

import java.util.List;

import static com.example.booksanddisks.features.products.presentation.PresenterFactory.getPresenter;

public class ProductsActivity extends AppCompatActivity implements ProductsListView {

    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private ProductsAdapter productsAdapter;
    private ProductsActivityPresenter productsActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        productsActivityPresenter = getPresenter();



        initView();
    }

    private void initView(){
        progressBar = findViewById(R.id.products_progress_bar);
        recyclerView = findViewById(R.id.products_recycler_view);

        productsAdapter = new ProductsAdapter(this, product -> productsActivityPresenter.onProductSelected(product));
        recyclerView.setAdapter(productsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        productsActivityPresenter.attachView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        productsActivityPresenter.detachView();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onBackPressed() {
        productsActivityPresenter.onBackPressed();
    }

    @Override
    public void openQuitDialog() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(
                this);
        quitDialog.setTitle(R.string.on_back_pressed);

        quitDialog.setPositiveButton(R.string.yes, (dialog, which) -> finish());

        quitDialog.setNegativeButton(R.string.no, (dialog, which) -> {
        });
        quitDialog.show();
    }

    @Override
    public void loadProducts() {
        productsActivityPresenter.loadProducts();
    }

    @Override
    public void setProductsToAdapter(List<Product> productList) {
        productsAdapter.setProducts(productList);
    }

    @Override
    public void loadInformation(Product product) {

    }
}
