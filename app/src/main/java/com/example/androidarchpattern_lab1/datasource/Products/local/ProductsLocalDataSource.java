package com.example.androidarchpattern_lab1.datasource.Products.local;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.androidarchpattern_lab1.Model.Product;
import com.example.androidarchpattern_lab1.db.AppDatabase;
import com.example.androidarchpattern_lab1.db.ProductsDAO;

import java.util.List;

public class ProductsLocalDataSource {
    private ProductsDAO productsDAO;

    public ProductsLocalDataSource(Context context) {
        productsDAO = AppDatabase.getInstance(context).productDao();
    }

    public LiveData<List<Product>> getFavouriteProducts() {

        return productsDAO.getFavouriteProducts();
    }

    public void addToFavourite(Product product) {
        new Thread(() -> {
            productsDAO.addToFavourite(product);
        }).start();
    }

    public void deleteFromFavourite(Product product) {
        new Thread(() -> {
            productsDAO.deleteFromFavourite(product);
        }).start();
    }
}
