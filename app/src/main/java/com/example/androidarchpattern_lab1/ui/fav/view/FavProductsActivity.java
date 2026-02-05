package com.example.androidarchpattern_lab1.ui.fav.view;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidarchpattern_lab1.datasource.Model.Product;
import com.example.androidarchpattern_lab1.R;
import com.example.androidarchpattern_lab1.datasource.Products.local.ProductsLocalDataSource;
import com.example.androidarchpattern_lab1.ui.fav.presenter.FavouritePresenter;
import com.example.androidarchpattern_lab1.ui.fav.presenter.FavouritePresenterImp;

import java.util.List;

public class FavProductsActivity extends AppCompatActivity implements OnFavoriteClickListener,FavouriteView {
    RecyclerView favProductsRv;
    FavoriteAdapter favoriteAdapter;
    TextView warningTxt;
    FavouritePresenter favouritePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fav);

        favouritePresenter = new FavouritePresenterImp (getApplication(),this);
        favoriteAdapter = new FavoriteAdapter(this);

        favProductsRv = findViewById(R.id.rvFavMProducts);
        warningTxt = findViewById(R.id.warningtxt);
        favProductsRv.setAdapter(favoriteAdapter);
        favouritePresenter.getFavouriteProducts();
/

    }

    @Override
    public void onClick(Product product) {
        favouritePresenter.deleteFromFavourite(product);
    }

    @Override
    public void showWarningText() {
        warningTxt.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideWarningText() {
        warningTxt.setVisibility(View.GONE);
    }

    @Override
    public void showProducts(List<Product> products) {

        favoriteAdapter.setList(products);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        favouritePresenter.clear();
    }
}
