package com.example.androidarchpattern_lab1.datasource.Products.remote;

import com.example.androidarchpattern_lab1.Model.ProductsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductService {
    @GET("products")
    Call<ProductsResponse> getProducts();
}
