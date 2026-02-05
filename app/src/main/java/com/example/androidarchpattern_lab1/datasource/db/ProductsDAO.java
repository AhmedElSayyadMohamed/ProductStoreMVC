package com.example.androidarchpattern_lab1.datasource.db;

import android.database.Observable;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.androidarchpattern_lab1.datasource.Model.Product;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

@Dao
public interface ProductsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable addToFavourite(Product product);

    @Delete
    Completable deleteFromFavourite(Product product);

    @Query("SELECT * FROM products")
    Flowable<List<Product>> getFavouriteProducts();

}
