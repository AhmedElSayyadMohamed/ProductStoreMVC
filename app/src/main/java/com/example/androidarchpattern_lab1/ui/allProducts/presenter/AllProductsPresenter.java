package com.example.androidarchpattern_lab1.ui.allProducts.presenter;

import com.example.androidarchpattern_lab1.datasource.Model.Product;

import java.util.List;

public interface AllProductsPresenter {

    void getAllProducts();

    void addProductToFav(Product product);

}
