package com.example.androidarchpattern_lab1.ui.allProducts.view;

import com.example.androidarchpattern_lab1.datasource.Model.Product;

import java.util.List;

public interface AllProductsView {
    void showLoading();
    void hideLoading();
    void showError(String message);
    void showProducts(List<Product> products);
}
