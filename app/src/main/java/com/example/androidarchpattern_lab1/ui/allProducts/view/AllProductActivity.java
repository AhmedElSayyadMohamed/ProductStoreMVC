package com.example.androidarchpattern_lab1.ui.allProducts.view;

import static android.view.View.GONE;
import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidarchpattern_lab1.datasource.Model.Product;
import com.example.androidarchpattern_lab1.R;
import com.example.androidarchpattern_lab1.ui.allProducts.presenter.AllProductsPresenter;
import com.example.androidarchpattern_lab1.ui.allProducts.presenter.AllProductsPresenterImp;

import java.util.List;

public class AllProductActivity extends AppCompatActivity implements OnProductClick ,AllProductsView{

    RecyclerView allProductsRecyclerView;
    ProgressBar loadingProgressBar;
    ProductAdapter adapter;
    TextView errorTextView;
    AllProductsPresenter allProductsPresenter;

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

        allProductsPresenter = new AllProductsPresenterImp(getApplication(), this);
        allProductsPresenter.getAllProducts();
    }

    @Override
    public void addProductToFav(Product product){
        allProductsPresenter.addProductToFav(product);
    }

    @Override
    public void showLoading() {
        loadingProgressBar.setVisibility(VISIBLE);
    }

    @Override
    public void hideLoading() {

        loadingProgressBar.setVisibility(INVISIBLE);
    }

    @Override
    public void showError(String message) {
        errorTextView.setVisibility(VISIBLE);
        errorTextView.setText(message);
    }

    @Override
    public void showProducts(List<Product> products) {
    adapter.setProductList(products);
    }
}
