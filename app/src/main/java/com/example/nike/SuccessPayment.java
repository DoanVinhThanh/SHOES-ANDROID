package com.example.nike;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.nike.Activity.User.CartActivity;
import com.example.nike.Activity.User.TrangChuActivity;

public class SuccessPayment extends AppCompatActivity {
    private Button btnThanhToan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_order_payment);
        btnThanhToan = findViewById(R.id.btn_Thanh_Toan);
        btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SuccessPayment.this , Successful_Payment_activity.class);
                startActivity(intent);
                finishAffinity();
            }
        });

    }
}