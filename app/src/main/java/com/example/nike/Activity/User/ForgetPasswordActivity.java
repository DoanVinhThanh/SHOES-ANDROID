package com.example.nike.Activity.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.nike.R;

public class ForgetPasswordActivity extends AppCompatActivity {
    TextView btnForgotSignIn, btnForgotSignUp;
    AppCompatButton btnForget;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        Anhxa();
        btnForgotSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgetPasswordActivity.this,SignInActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnForgotSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgetPasswordActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ForgetPasswordActivity.this, TrangChuActivity.class);
                startActivity(intent);
            }
        });
    }

    public void Anhxa() {
        btnForgotSignIn = findViewById(R.id.btn_forgot_signin);
        btnForgotSignUp = findViewById(R.id.btn_forgot_signup);
        btnForget = findViewById(R.id.btn_forget);

    }
}