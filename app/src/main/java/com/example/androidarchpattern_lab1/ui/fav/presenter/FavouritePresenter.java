package com.example.androidarchpattern_lab1.ui.fav.presenter;


import androidx.lifecycle.LiveData;

import com.example.androidarchpattern_lab1.datasource.Model.Product;

import java.util.List;

public interface FavouritePresenter {

    void getFavouriteProducts();
    void deleteFromFavourite(Product product);
    void clear();
}