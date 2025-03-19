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

public class Successful_Payment_activity extends AppCompatActivity {
    private Button btnThanhCong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successful_payment);
        btnThanhCong = findViewById(R.id.btn_Thanh_Cong);
        btnThanhCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Successful_Payment_activity.this , TrangChuActivity.class);
                startActivity(intent);
                finishAffinity();
            }
        });

    }
}