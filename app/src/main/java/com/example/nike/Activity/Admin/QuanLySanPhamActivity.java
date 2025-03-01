package com.example.nike.Activity.Admin;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nike.Adapter.ProductAdminAdapter;
import com.example.nike.DatabaseHelper;
import com.example.nike.Model.ProductAdmin;
import com.example.nike.R;

import java.util.List;

public class QuanLySanPhamActivity extends AppCompatActivity {
    ImageView btnBackProductAdmin;
    private RecyclerView recyclerView;
    private ProductAdminAdapter adapter;
    private DatabaseHelper databaseHelper;
    private AppCompatButton btnAddProduct;
    private List<ProductAdmin> productList;
    private static final int REQUEST_PERMISSION_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_san_pham);
        btnBackProductAdmin = findViewById(R.id.btn_back_product_admin);
        recyclerView = findViewById(R.id.recyclerView_product);
        btnAddProduct = findViewById(R.id.btnAddProduct);
        databaseHelper = new DatabaseHelper(this);
        btnBackProductAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuanLySanPhamActivity.this,AdminTrangChuActivity.class);
                startActivity(intent);
                finish();
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Kiểm tra quyền trước khi load sản phẩm
        checkAndRequestPermission();

        btnAddProduct.setOnClickListener(v ->
                startActivity(new Intent(QuanLySanPhamActivity.this, AddEditProductActivity.class))
        );
    }

    private void loadProducts() {
        productList = databaseHelper.getAllProducts();
        adapter = new ProductAdminAdapter(productList, this);
        recyclerView.setAdapter(adapter);
    }

    public void deleteProduct(final int productId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Xóa sản phẩm");
        builder.setMessage("Bạn có chắc chắn muốn xóa sản phẩm này?");
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                databaseHelper.deleteProduct(productId);
                Toast.makeText(QuanLySanPhamActivity.this, "Đã xóa sản phẩm", Toast.LENGTH_SHORT).show();
                loadProducts();
            }
        });
        builder.setNegativeButton("Không", null);
        builder.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadProducts();
    }

    // Kiểm tra quyền truy cập ảnh
    private void checkAndRequestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) { // Android 13+
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_MEDIA_IMAGES)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_MEDIA_IMAGES}, REQUEST_PERMISSION_CODE);
            } else {
                loadProducts();
            }
        } else { // Android 12 trở xuống
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_PERMISSION_CODE);
            } else {
                loadProducts();
            }
        }
    }

    // Xử lý kết quả yêu cầu quyền
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.d("Permission", "Quyền truy cập ảnh đã được cấp!");
                loadProducts();
            } else {
                Log.e("Permission", "Người dùng từ chối cấp quyền!");
                Toast.makeText(this, "Không thể hiển thị ảnh sản phẩm nếu không cấp quyền!", Toast.LENGTH_LONG).show();
            }
        }
    }
}
