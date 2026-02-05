package com.example.androidarchpattern_lab1.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidarchpattern_lab1.R;
import com.example.androidarchpattern_lab1.ui.allProducts.view.AllProductActivity;
import com.example.androidarchpattern_lab1.ui.fav.view.FavProductsActivity;

public class MainActivity extends AppCompatActivity {

    Button exitBtn;
    Button allProductsBtn;
    Button favProductsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

        allProductsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AllProductActivity.class);
                startActivity(intent);
            }
        });
        favProductsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FavProductsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initUI() {
        exitBtn = findViewById(R.id.btnExit);
        allProductsBtn = findViewById(R.id.btnGetAllProducts);
        favProductsBtn = findViewById(R.id.btnFavProducts);
    }

}
