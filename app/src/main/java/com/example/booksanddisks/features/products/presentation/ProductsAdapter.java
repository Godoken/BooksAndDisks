package com.example.booksanddisks.features.products.presentation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.booksanddisks.R;
import com.example.booksanddisks.features.products.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductsHolder> {

    private final List<Product> products = new ArrayList<>();
    private final LayoutInflater layoutInflater;
    private final SelectProductListener selectProductListener;

    public ProductsAdapter(Context context, SelectProductListener selectProductListener){
        layoutInflater = LayoutInflater.from(context);
        this.selectProductListener = selectProductListener;
    }

    @NonNull
    @Override
    public ProductsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View itemView = layoutInflater.inflate(R.layout.product_item, parent, false);
        return new ProductsHolder(itemView, selectProductListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsAdapter.ProductsHolder holder, int position) {
        holder.bind(products.get(position));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void setProducts(List<Product> productList) {
        products.clear();
        products.addAll(productList);
        notifyDataSetChanged();
    }

    class ProductsHolder extends RecyclerView.ViewHolder {

        private final TextView productTitle;
        private final TextView productSubtitle;
        private final SelectProductListener selectProductListener;

        public ProductsHolder(@NonNull View itemView, SelectProductListener selectProductListener) {
            super(itemView);
            this.selectProductListener = selectProductListener;
            productTitle = itemView.findViewById(R.id.product_item_title);
            productSubtitle = itemView.findViewById(R.id.product_item_subtitle);
        }

        void bind(final Product product) {
            productTitle.setText(product.getProductTitle());
            productSubtitle.setText(product.getProductSubtitle().toString());

            itemView.setOnClickListener(v -> selectProductListener.onProductSelect(product));
        }
    }

    interface SelectProductListener {
        void onProductSelect(Product product);
    }
}
