package com.example.androidarchpattern_lab1.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.androidarchpattern_lab1.Model.Product;

import java.util.List;

@Dao
public interface ProductsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addToFavourite(Product product);

    @Delete
    void deleteFromFavourite(Product product);

    @Query("SELECT * FROM products")
   LiveData<List<Product>> getFavouriteProducts();

}
