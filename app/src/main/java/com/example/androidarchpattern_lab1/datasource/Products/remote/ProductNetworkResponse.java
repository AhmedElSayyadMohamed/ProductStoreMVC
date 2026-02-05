
package com.example.androidarchpattern_lab1.datasource.Products.remote;

import com.example.androidarchpattern_lab1.datasource.Model.Product;

import java.util.List;

public interface ProductNetworkResponse {
    void onSuccess(List<Product> products);
    void onFailure(String message);
    void noInternet();
}
