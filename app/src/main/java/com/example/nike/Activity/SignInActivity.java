package com.example.nike.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.nike.R;

public class SignInActivity extends AppCompatActivity {
    TextView btnSignInForgot , btnSignInSignUp;
    AppCompatButton btnSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Anhxa();
        btnSignInForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, ForgetPasswordActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnSignInSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInActivity.this, TrangChuActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void Anhxa(){
        btnSignInForgot = findViewById(R.id.btn_signin_forgot);
        btnSignInSignUp = findViewById(R.id.btn_signin_signup);
        btnSignIn = findViewById(R.id.btn_sign_in);
    }
}