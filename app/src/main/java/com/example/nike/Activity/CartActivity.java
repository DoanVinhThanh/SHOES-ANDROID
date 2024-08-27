package com.example.nike.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nike.Adapter.CategoryAdapter;
import com.example.nike.Adapter.ProductAdapter;
import com.example.nike.Model.Category;
import com.example.nike.Model.Product;
import com.example.nike.R;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    private RecyclerView recyclerView_cart;
    private TextView tvEmptyMessage_cart;
    private ImageView imgEmpty_cart;
    private AppCompatButton btn_Shopnow_cart;

    LinearLayout Linear_total_cart;
    private ProductAdapter adapter;
    private List<Product> favoriteShoesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Anhxa();


        // Giả sử dữ liệu được lấy từ cơ sở dữ liệu hoặc một nguồn khác
        setDataRCVcart();

        if (favoriteShoesList.isEmpty()) {
            tvEmptyMessage_cart.setVisibility(View.VISIBLE);
            imgEmpty_cart.setVisibility(View.VISIBLE);
            btn_Shopnow_cart.setVisibility(View.VISIBLE);
            recyclerView_cart.setVisibility(View.GONE);
            Linear_total_cart.setVisibility(View.GONE);
        } else {
            tvEmptyMessage_cart.setVisibility(View.GONE);
            imgEmpty_cart.setVisibility(View.GONE);
            btn_Shopnow_cart.setVisibility(View.GONE);
            recyclerView_cart.setVisibility(View.VISIBLE);
            Linear_total_cart.setVisibility(View.VISIBLE);
            recyclerView_cart.setLayoutManager(new LinearLayoutManager(this));
            adapter = new ProductAdapter(favoriteShoesList);
            recyclerView_cart.setAdapter(adapter);
        }
    }
    private void Anhxa(){
        recyclerView_cart = findViewById(R.id.recycler_view_cart);
        tvEmptyMessage_cart = findViewById(R.id.empty_msg_cart);
        imgEmpty_cart = findViewById(R.id.empty_img_cart);
        btn_Shopnow_cart = findViewById(R.id.btnShopnow_cart);
        Linear_total_cart = findViewById(R.id.total_cart);
    }

    private void setDataRCVcart(){
        recyclerView_cart.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false ));

        favoriteShoesList = new ArrayList<>();
        favoriteShoesList.add(new Product(R.drawable.nike_vaporfly_3_electric, "Nike Vaporfly 3 Electric"));



        adapter = new ProductAdapter(favoriteShoesList);
        recyclerView_cart.setAdapter(adapter);
    }
    }