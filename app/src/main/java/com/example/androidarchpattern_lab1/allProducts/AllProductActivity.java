package com.example.androidarchpattern_lab1.allProducts;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidarchpattern_lab1.Model.Product;
import com.example.androidarchpattern_lab1.R;
import com.example.androidarchpattern_lab1.datasource.Products.local.ProductsLocalDataSource;
import com.example.androidarchpattern_lab1.datasource.Products.remote.ProductNetworkResponse;
import com.example.androidarchpattern_lab1.datasource.Products.remote.ProductsRemoteDataSource;

import java.util.List;

public class AllProductActivity extends AppCompatActivity implements OnProductClick {

    RecyclerView allProductsRecyclerView;
    ProgressBar loadingProgressBar;
    ProductAdapter adapter;
    TextView errorTextView;
    ProductsRemoteDataSource productsRemoteDataSource;
    ProductsLocalDataSource productsLocalDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_all_product);

        allProductsRecyclerView = findViewById(R.id.rv_products);
        loadingProgressBar = findViewById(R.id.progress_circular);
        errorTextView = findViewById(R.id.tv_error);
        adapter = new ProductAdapter(this);
        allProductsRecyclerView.setAdapter(adapter);

        productsRemoteDataSource = new ProductsRemoteDataSource();
        productsLocalDataSource = new ProductsLocalDataSource(getApplicationContext());


        loadingProgressBar.setVisibility(VISIBLE);
        productsRemoteDataSource.getAllProducts(new ProductNetworkResponse() {

            @Override
            public void onSuccess(List<Product> products) {
                loadingProgressBar.setVisibility(GONE);
                errorTextView.setVisibility(GONE);
                allProductsRecyclerView.setVisibility(VISIBLE);
                adapter.setProductList(products);
            }

            @Override
            public void onFailure(String message) {
                loadingProgressBar.setVisibility(GONE);
                errorTextView.setVisibility(VISIBLE);
                errorTextView.setText("There is a problem with the server");
            }

            @Override
            public void noInternet() {
                loadingProgressBar.setVisibility(GONE);
                errorTextView.setVisibility(VISIBLE);
                errorTextView.setText("No Internet Connection");
            }
        });
    }

    @Override
   public void addProductToFav(Product product){
        productsLocalDataSource.addToFavourite(product);
        Toast.makeText(this, "Added to favourite Successfully", Toast.LENGTH_SHORT).show();
    }
}
