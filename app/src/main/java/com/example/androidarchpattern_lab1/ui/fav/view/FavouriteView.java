package com.example.androidarchpattern_lab1.ui.fav.view;

import com.example.androidarchpattern_lab1.datasource.Model.Product;

import java.util.List;

public interface FavouriteView {

    void showWarningText();
    void hideWarningText();
    void showProducts(List<Product> products);
    void showError(String message);

}
