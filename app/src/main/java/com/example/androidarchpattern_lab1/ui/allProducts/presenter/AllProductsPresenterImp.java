package com.example.androidarchpattern_lab1.ui.allProducts.presenter;


import android.app.Application;
import android.widget.Toast;

import com.example.androidarchpattern_lab1.datasource.Model.Product;
import com.example.androidarchpattern_lab1.datasource.Products.Repository.ProductsRepository;
import com.example.androidarchpattern_lab1.datasource.Products.local.ProductsLocalDataSource;
import com.example.androidarchpattern_lab1.datasource.Products.remote.ProductNetworkResponse;
import com.example.androidarchpattern_lab1.datasource.Products.remote.ProductsRemoteDataSource;
import com.example.androidarchpattern_lab1.ui.allProducts.view.AllProductsView;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class AllProductsPresenterImp implements AllProductsPresenter {

    ProductsRepository productsRepository;
    AllProductsView allProductsView;
    Application application;
   public AllProductsPresenterImp(Application application, AllProductsView allProductsView){
       this.application = application;
       productsRepository = new ProductsRepository(application);
        this.allProductsView = allProductsView;
    }

    @Override
    public void getAllProducts(){

        allProductsView.showLoading();
        productsRepository.getAllProducts()
                .subscribeOn(Schedulers.io())
                .map(item->item.geProducts())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                list -> {
                    allProductsView.hideLoading();
                    allProductsView.showProducts(list);
                },
                throwable -> {
                    allProductsView.hideLoading();
                    allProductsView.showError(throwable.getMessage());
                }
        );


    }


    @Override
   public void addProductToFav(Product product){
        productsRepository.addToFavourite(product)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        () -> {
                            Toast.makeText(application.getApplicationContext(), "Added to favourite Successfully", Toast.LENGTH_SHORT).show();
                        },
                        throwable -> {
                            allProductsView.showError(throwable.getMessage());
                        }
                );
    }


}
