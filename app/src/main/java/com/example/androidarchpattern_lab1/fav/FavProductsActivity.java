package com.example.androidarchpattern_lab1.fav;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidarchpattern_lab1.Model.Product;
import com.example.androidarchpattern_lab1.R;
import com.example.androidarchpattern_lab1.allProducts.fav.OnFavoriteClickListener;
import com.example.androidarchpattern_lab1.datasource.Products.local.ProductsLocalDataSource;

import java.util.List;

public class FavProductsActivity extends AppCompatActivity implements OnFavoriteClickListener {
    RecyclerView favProductsRv;
    FavoriteAdapter favoriteAdapter;
    TextView warningTxt;
    ProductsLocalDataSource productsLocalDataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fav);
        favoriteAdapter = new FavoriteAdapter(this);
        favProductsRv = findViewById(R.id.rvFavMProducts);
        warningTxt = findViewById(R.id.warningtxt);
        favProductsRv.setAdapter(favoriteAdapter);
        productsLocalDataSource = new ProductsLocalDataSource(getApplicationContext());

        productsLocalDataSource.getFavouriteProducts().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                if(products.size() == 0){
                    warningTxt.setVisibility(View.VISIBLE);
                }else{
                    warningTxt.setVisibility(View.GONE);
                }

                favoriteAdapter.setList(products);

            }
        });

    }

    @Override
    public void onClick(Product product) {
       productsLocalDataSource.deleteFromFavourite(product);
    }
}
