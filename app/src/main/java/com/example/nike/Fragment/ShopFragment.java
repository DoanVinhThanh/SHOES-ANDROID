package com.example.nike.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;

import com.example.nike.Activity.TrangChuActivity;
import com.example.nike.R;
import com.google.android.material.textfield.TextInputEditText;


public class ShopFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shop, container, false);
        Anhxa(view);

        



        return view;
    }

    private void Anhxa(View view){

    }
}