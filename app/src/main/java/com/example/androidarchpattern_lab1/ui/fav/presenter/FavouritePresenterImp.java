package com.example.androidarchpattern_lab1.ui.fav.presenter;

import android.app.Application;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.example.androidarchpattern_lab1.datasource.Model.Product;
import com.example.androidarchpattern_lab1.datasource.Products.Repository.ProductsRepository;
import com.example.androidarchpattern_lab1.datasource.Products.local.ProductsLocalDataSource;
import com.example.androidarchpattern_lab1.ui.fav.view.FavouriteView;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class FavouritePresenterImp implements FavouritePresenter {
    ProductsRepository productsRepository;
    FavouriteView favouriteView;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public FavouritePresenterImp(Application application, FavouriteView favouriteView) {
        productsRepository = new ProductsRepository(application);
        this.favouriteView = favouriteView;
    }

    @Override
    public void getFavouriteProducts() {
        compositeDisposable.add(
                productsRepository.getFavouriteProducts()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                list -> {
                                    if (list == null || list.isEmpty()) {
                                        favouriteView.showWarningText();
                                    } else {
                                        favouriteView.hideWarningText();
                                        favouriteView.showProducts(list);
                                    }
                                },
                                throwable -> favouriteView.showError(throwable.getMessage())
                        )
        );
    }

    @Override
    public void deleteFromFavourite(Product product) {
        compositeDisposable.add(
                productsRepository.deleteFromFavourite(product)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                () -> {},
                                throwable -> favouriteView.showError(throwable.getMessage())
                        )
        );
    }

    @Override
    public void clear() {
        compositeDisposable.clear();
    }
}
