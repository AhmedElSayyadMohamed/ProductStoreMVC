package com.example.androidarchpattern_lab1.ui.allProducts.view;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.androidarchpattern_lab1.datasource.Model.Product;
import com.example.androidarchpattern_lab1.R;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> productList;

    private OnProductClick onProductClick;

    public ProductAdapter(OnProductClick onProductClick) {

        this.productList = new ArrayList<>();
        this.onProductClick = onProductClick;
    }

   public void setProductList(List<Product> productList) {
        this.productList = productList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        Product product = productList.get(position);

        holder.title.setText(product.getTitle());
        holder.price.setText("$" + product.getPrice());
        holder.favBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onProductClick.addProductToFav(product);
            }

        });


        Glide.with(holder.img.getContext())
                .load(product.getThumbnail())
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView title, price;
        Button favBtn;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.iv_poster);
            title = itemView.findViewById(R.id.tv_name);
            price = itemView.findViewById(R.id.tv_category);
            favBtn = itemView.findViewById(R.id.btn_addToFav);
        }
    }

}
