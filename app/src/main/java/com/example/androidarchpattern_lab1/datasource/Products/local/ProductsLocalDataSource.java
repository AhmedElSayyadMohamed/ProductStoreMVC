package com.example.androidarchpattern_lab1.datasource.Products.local;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.androidarchpattern_lab1.datasource.Model.Product;
import com.example.androidarchpattern_lab1.datasource.db.AppDatabase;
import com.example.androidarchpattern_lab1.datasource.db.ProductsDAO;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

public class ProductsLocalDataSource {
    private ProductsDAO productsDAO;

    public ProductsLocalDataSource(Context context) {
        productsDAO = AppDatabase.getInstance(context).productDao();
    }

    public Flowable<List<Product>> getFavouriteProducts() {

        return productsDAO.getFavouriteProducts();
    }

    public Completable addToFavourite(Product product) {
        return productsDAO.addToFavourite(product);
    }

    public Completable deleteFromFavourite(Product product) {
        return productsDAO.deleteFromFavourite(product);
    }
}
