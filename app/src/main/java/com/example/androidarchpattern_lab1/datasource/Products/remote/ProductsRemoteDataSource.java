package com.example.androidarchpattern_lab1.datasource.Products.remote;

import com.example.androidarchpattern_lab1.Model.Network.Network;
import com.example.androidarchpattern_lab1.datasource.Products.remote.ProductNetworkResponse;
import com.example.androidarchpattern_lab1.Model.ProductsResponse;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsRemoteDataSource {

    private ProductService productService;

    public ProductsRemoteDataSource() {
        productService = Network.getInstance().create(ProductService.class);
    }

    public void getAllProducts(ProductNetworkResponse callback) {

        productService.getProducts().enqueue(new Callback<ProductsResponse>() {

            @Override
            public void onResponse(Call<ProductsResponse> call,
                                   Response<ProductsResponse> response) {

                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body().geProducts());
                } else {
                    callback.onFailure("Server Error");
                }
            }

            @Override
            public void onFailure(Call<ProductsResponse> call, Throwable t) {
                if (t instanceof IOException) {
                    callback.noInternet();
                } else {
                    callback.onFailure(t.getMessage());
                }
            }
        });
    }

}
