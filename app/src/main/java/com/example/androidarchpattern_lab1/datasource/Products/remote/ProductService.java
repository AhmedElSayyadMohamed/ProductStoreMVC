package com.example.androidarchpattern_lab1.datasource.Products.remote;

import com.example.androidarchpattern_lab1.datasource.Model.ProductsResponse;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductService {
    @GET("products")
    Single<ProductsResponse> getProducts();
}
