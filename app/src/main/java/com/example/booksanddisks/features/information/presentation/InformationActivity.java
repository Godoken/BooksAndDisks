package com.example.booksanddisks.features.information.presentation;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.booksanddisks.R;

public class InformationActivity extends AppCompatActivity implements InformationView {

    private InformationActivityPresenter informationActivityPresenter;
    private ProgressBar progressBar;

    private TextView title;
    private TextView subtitle;
    private TextView price;
    private TextView barCode;
    private TextView important;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        informationActivityPresenter = PresenterFactory.getPresenter(getIntent().getStringArrayListExtra("information"));
        initView();
    }

    private void initView() {
        progressBar = findViewById(R.id.informationProgress);
        title = findViewById(R.id.title);
        subtitle = findViewById(R.id.subtitle);
        price = findViewById(R.id.price);
        barCode = findViewById(R.id.barcode);
        important = findViewById(R.id.important);
    }

    @Override
    protected void onStart() {
        super.onStart();
        informationActivityPresenter.attachView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        informationActivityPresenter.detachView();
    }


    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        title.setVisibility(View.GONE);
        subtitle.setVisibility(View.GONE);
        price.setVisibility(View.GONE);
        barCode.setVisibility(View.GONE);
        important.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        title.setVisibility(View.VISIBLE);
        subtitle.setVisibility(View.VISIBLE);
        price.setVisibility(View.VISIBLE);
        barCode.setVisibility(View.VISIBLE);
        important.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showInformation(String title, String subtitle, String price, String barCode, String important) {
        this.title.setText(title);
        this.subtitle.setText(subtitle);
        this.price.setText(price);
        this.barCode.setText(barCode);
        this.important.setText(important);
    }
}
