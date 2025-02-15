package com.example.nike.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nike.R;

public class ForgetPasswordActivity extends AppCompatActivity {
    TextView btnForgotSignIn, btnForgotSignUp;
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
            }
        });
        btnForgotSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgetPasswordActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    public void Anhxa() {
        btnForgotSignIn = findViewById(R.id.btn_forgot_signin);
        btnForgotSignUp = findViewById(R.id.btn_forgot_signup);

    }
}