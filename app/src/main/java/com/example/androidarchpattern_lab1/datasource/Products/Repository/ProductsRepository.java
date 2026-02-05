package com.example.androidarchpattern_lab1.datasource.Products.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.androidarchpattern_lab1.datasource.Model.Product;
import com.example.androidarchpattern_lab1.datasource.Model.ProductsResponse;
import com.example.androidarchpattern_lab1.datasource.Products.local.ProductsLocalDataSource;
import com.example.androidarchpattern_lab1.datasource.Products.remote.ProductsRemoteDataSource;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;

public class ProductsRepository {
    ProductsRemoteDataSource productsRemoteDataSource;
    ProductsLocalDataSource productsLocalDataSource;

    public ProductsRepository(Application application){
        productsRemoteDataSource = new ProductsRemoteDataSource();
        productsLocalDataSource = new ProductsLocalDataSource(application);
    }
    public Flowable<List<Product>> getFavouriteProducts(){
        return productsLocalDataSource.getFavouriteProducts();
    }

    public Completable addToFavourite(Product product) {
        return productsLocalDataSource.addToFavourite(product);
    }

    public Completable deleteFromFavourite(Product product) {
        return productsLocalDataSource.deleteFromFavourite(product);
    }

    public Single<ProductsResponse> getAllProducts() {
         return productsRemoteDataSource.getAllProducts();
    }

}
