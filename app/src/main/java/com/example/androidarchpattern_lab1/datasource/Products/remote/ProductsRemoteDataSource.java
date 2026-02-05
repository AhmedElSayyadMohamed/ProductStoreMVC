package com.example.androidarchpattern_lab1.datasource.Products.remote;

import com.example.androidarchpattern_lab1.datasource.Network.Network;
import com.example.androidarchpattern_lab1.datasource.Model.ProductsResponse;

import java.io.IOException;
import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsRemoteDataSource {

    private ProductService productService;

    public ProductsRemoteDataSource() {
        productService = Network.getInstance().create(ProductService.class);
    }

    public Single<ProductsResponse> getAllProducts() {

        return productService.getProducts();

    }

}
