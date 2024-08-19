package com.example.nike.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.nike.R;

public class SettingActivity extends AppCompatActivity {

    ImageView btn_setting_shop_to_home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Anhxa();
        btn_setting_shop_to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingActivity.this, TrangChuActivity.class);
                startActivity(intent);
                

            }
        });

    }
    private void Anhxa()
    {
        btn_setting_shop_to_home = findViewById(R.id.btn_setting_shop_to_home);
    }
}

